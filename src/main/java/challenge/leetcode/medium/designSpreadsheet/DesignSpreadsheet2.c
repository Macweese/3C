#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <stdbool.h>

#if defined(__GNUC__) || defined(__clang__)
#define LIKELY(x)   (__builtin_expect(!!(x), 1))
#define UNLIKELY(x) (__builtin_expect(!!(x), 0))
#else
#define LIKELY(x)   (x)
#define UNLIKELY(x) (x)
#endif

static inline bool a_isdigit(unsigned char c)
{
    return c >= '0' && c <= '9';
}

static inline unsigned char a_to_upper(unsigned char c)
{
    return (unsigned char)(c & (unsigned char)~0x20);
}

static inline bool a_isalpha(unsigned char c)
{
    unsigned char u = a_to_upper(c);
    return u >= 'A' && u <= 'Z';
}

static inline bool a_isspace(unsigned char c)
{
    return c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == '\v' || c == '\f';
}

typedef struct
{
    uint64_t *keys;
    int      *vals;
    size_t    cap;
    size_t    mask;
    unsigned  shift;
    size_t    used;
}
CellMap;

typedef struct
{
    int rows;
    CellMap map;
}
Spreadsheet;

static inline uint64_t make_key(uint32_t row, uint32_t col)
{
    return (((uint64_t)row) << 32) | (uint64_t)col;
}

static inline uint64_t pack_key(uint64_t k)
{
    return k + 1u;
}

static inline unsigned ilog2_zu(size_t x)
{
#if defined(__GNUC__) || defined(__clang__)
    return (unsigned)(8u * sizeof(unsigned long long) - 1u - __builtin_clzll((unsigned long long)x));
#else
    unsigned r = 0;
    while (((size_t)1 << (r+1)) <= x)
    {
        r++;
    }
    return r;
#endif
}

static inline size_t hash_index64(uint64_t slot_key, unsigned shift)
{
    const uint64_t MUL = 11400714819323198485ull;
    return (size_t)((slot_key * MUL) >> shift);
}

static void cellmap_init(CellMap *m, size_t initial_cap)
{
    if (initial_cap < 8)
    {
        initial_cap = 8;
    }
    size_t cap = 8;
    while (cap < initial_cap)
    {
        cap <<= 1;
    }
    m->cap  = cap;
    m->mask = cap - 1;
    m->shift = 64u - ilog2_zu(cap);
    m->used = 0;
    m->keys = (uint64_t*)calloc(cap, sizeof(uint64_t));
    m->vals = (int*)calloc(cap, sizeof(int));
}

static void cellmap_free(CellMap *m)
{
    free(m->keys);
    m->keys = NULL;
    free(m->vals);
    m->vals = NULL;
    m->cap = m->mask = m->used = 0;
    m->shift = 0;
}

static void cellmap_rehash(CellMap *m, size_t new_cap)
{
    size_t cap = 8;
    while (cap < new_cap)
    {
        cap <<= 1;
    }

    uint64_t *old_keys = m->keys;
    int      *old_vals = m->vals;
    size_t     old_cap = m->cap;

    m->cap  = cap;
    m->mask = cap - 1;
    m->shift = 64u - ilog2_zu(cap);
    m->used = 0;
    m->keys = (uint64_t*)calloc(cap, sizeof(uint64_t));
    m->vals = (int*)calloc(cap, sizeof(int));

    for (size_t i = 0; i < old_cap; ++i)
    {
        uint64_t sk = old_keys[i];
        if (sk != 0)
        {
            size_t idx = hash_index64(sk, m->shift);
            while (m->keys[idx] != 0)
            {
                idx = (idx + 1) & m->mask;
            }
            m->keys[idx] = sk;
            m->vals[idx] = old_vals[i];
            m->used++;
        }
    }
    free(old_keys);
    free(old_vals);
}

static inline void cellmap_maybe_grow(CellMap *m)
{
    if (LIKELY((m->used + 1) * 10 < m->cap * 7))
    {
        return;
    }
    cellmap_rehash(m, m->cap << 1);
}

static void cellmap_set(CellMap *m, uint64_t raw_key, int val)
{
    cellmap_maybe_grow(m);
    uint64_t sk = pack_key(raw_key);
    size_t idx = hash_index64(sk, m->shift);
    while (1)
    {
        uint64_t cur = m->keys[idx];
        if (cur == 0)
        {
            m->keys[idx] = sk;
            m->vals[idx] = val;
            m->used++;
            return;
        }
        if (cur == sk)
        {
            m->vals[idx] = val;
            return;
        }
        idx = (idx + 1) & m->mask;
    }
}

static inline int cellmap_get_or_zero_snapshot(const uint64_t *keys, const int *vals,
                                               size_t mask, unsigned shift, uint64_t raw_key)
{
    uint64_t sk = pack_key(raw_key);
    size_t idx = hash_index64(sk, shift);
    while (1)
    {
        uint64_t cur = keys[idx];
        if (cur == 0)
        {
            return 0;
        }
        if (cur == sk)
        {
            return vals[idx];
        }
        idx = (idx + 1) & mask;
    }
}

static inline void skip_spaces(const char **ps)
{
    const char *s = *ps;
    while (*s && a_isspace((unsigned char)*s))
    {
        s++;
    }
    *ps = s;
}

static inline bool parse_column_index(const char **ps, uint32_t *out_col)
{
    const char *s = *ps;
    if (!a_isalpha((unsigned char)*s))
    {
        return false;
    }
    uint32_t v = 0;
    unsigned char c = (unsigned char)*s;
    while (a_isalpha(c))
    {
        unsigned char u = a_to_upper(c);
        v = v * 26u + (uint32_t)(u - 'A' + 1u);
        s++;
        c = (unsigned char)*s;
    }
    if (v == 0)
    {
        return false;
    }
    *out_col = v - 1u;
    *ps = s;
    return true;
}

static inline bool parse_uint(const char **ps, uint32_t *out_num)
{
    const char *s = *ps;
    if (!a_isdigit((unsigned char)*s))
    {
        return false;
    }
    uint32_t v = 0;
    unsigned char c = (unsigned char)*s;
    while (a_isdigit(c))
    {
        v = v * 10u + (uint32_t)(c - '0');
        s++;
        c = (unsigned char)*s;
    }
    *out_num = v;
    *ps = s;
    return true;
}

typedef struct
{
    const uint64_t *keys;
    const int      *vals;
    size_t          mask;
    unsigned        shift;
    int             rows;
    const char     *s;
}
Parser;

static int parse_expr(Parser *p);

static int parse_number(Parser *p)
{
    skip_spaces(&p->s);
    bool neg = false;
    if (*p->s == '+')
    {
        p->s++;
    }
    else if (*p->s == '-')
    {
        neg = true;
        p->s++;
    }
    skip_spaces(&p->s);
    if (!a_isdigit((unsigned char)*p->s))
    {
        return 0;
    }
    int v = 0;
    while (a_isdigit((unsigned char)*p->s))
    {
        v = v * 10 + (*p->s - '0');
        p->s++;
    }
    return neg ? -v : v;
}

static int parse_factor(Parser *p)
{
    skip_spaces(&p->s);
    if (*p->s == '(')
    {
        p->s++;
        int v = parse_expr(p);
        skip_spaces(&p->s);
        if (*p->s == ')')
        {
            p->s++;
        }
        return v;
    }

    const char *start = p->s;
    uint32_t col;
    if (parse_column_index(&p->s, &col))
    {
        uint32_t row1;
        if (parse_uint(&p->s, &row1))
        {
            int row0 = (int)row1 - 1;
            if (row0 >= 0 && row0 < p->rows)
            {
                uint64_t k = make_key((uint32_t)row0, col);
                return cellmap_get_or_zero_snapshot(p->keys, p->vals, p->mask, p->shift, k);
            }
            else
            {
                return 0;
            }
        }
        p->s = start;
    }
    return parse_number(p);
}

static int parse_term(Parser *p)
{
    int v = parse_factor(p);
    while (1)
    {
        skip_spaces(&p->s);
        char op = *p->s;
        if (op != '*' && op != '/')
        {
            break;
        }
        p->s++;
        int rhs = parse_factor(p);
        if (op == '*')
        {
            v = v * rhs;
        }
        else
        {
            v = (rhs != 0) ? (v / rhs) : 0;
        }
    }
    return v;
}

static int parse_expr(Parser *p)
{
    int v = parse_term(p);
    while (1)
    {
        skip_spaces(&p->s);
        char op = *p->s;
        if (op != '+' && op != '-')
        {
            break;
        }
        p->s++;
        int rhs = parse_term(p);
        if (op == '+')
        {
            v += rhs;
        }
        else
        {
            v -= rhs;
        }
    }
    return v;
}

Spreadsheet* spreadsheetCreate(int rows)
{
    Spreadsheet *ss = (Spreadsheet*)calloc(1, sizeof(Spreadsheet));
    ss->rows = rows > 0 ? rows : 0;
    cellmap_init(&ss->map, 2048);
    return ss;
}

static inline bool parse_cell_ref(const char *cell, int max_rows, uint32_t *out_row0, uint32_t *out_col0)
{
    const char *s = cell;
    uint32_t col;
    if (!parse_column_index(&s, &col))
    {
        return false;
    }
    uint32_t row1;
    if (!parse_uint(&s, &row1))
    {
        return false;
    }
    while (*s && a_isspace((unsigned char)*s))
    {
        s++;
    }
    if (*s != '\0')
    {
        return false;
    }
    int row0 = (int)row1 - 1;
    if (row0 < 0 || row0 >= max_rows)
    {
        return false;
    }
    *out_row0 = (uint32_t)row0;
    *out_col0 = col;
    return true;
}

void spreadsheetSetCell(Spreadsheet* obj, char* cell, int value)
{
    if (UNLIKELY(!obj || !cell))
    {
        return;
    }
    uint32_t r0, c0;
    if (!parse_cell_ref(cell, obj->rows, &r0, &c0))
    {
        return;
    }
    cellmap_set(&obj->map, make_key(r0, c0), value);
}

void spreadsheetResetCell(Spreadsheet* obj, char* cell)
{
    if (UNLIKELY(!obj || !cell))
    {
        return;
    }
    uint32_t r0, c0;
    if (!parse_cell_ref(cell, obj->rows, &r0, &c0))
    {
        return;
    }
    cellmap_set(&obj->map, make_key(r0, c0), 0);
}

int spreadsheetGetValue(Spreadsheet* obj, char* formula)
{
    if (UNLIKELY(!obj || !formula))
    {
        return 0;
    }
    const char *s = formula;
    while (*s && a_isspace((unsigned char)*s))
    {
        s++;
    }
    if (*s == '=')
    {
        s++;
        while (*s && a_isspace((unsigned char)*s))
        {
            s++;
        }
    }
    Parser p;
    p.keys  = obj->map.keys;
    p.vals  = obj->map.vals;
    p.mask  = obj->map.mask;
    p.shift = obj->map.shift;
    p.rows  = obj->rows;
    p.s     = s;
    return parse_expr(&p);
}

void spreadsheetFree(Spreadsheet* obj)
{
    if (!obj)
    {
        return;
    }
    cellmap_free(&obj->map);
    free(obj);
}