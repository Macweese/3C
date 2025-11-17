#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdint.h>
#include <stdbool.h>

typedef struct
{
    uint64_t *keys;
    int *values;
    unsigned char *states;
    size_t cap;
    size_t size;
}
CellMap;

typedef struct
{
    int rows;
    CellMap map;
}
Spreadsheet;

static uint64_t splitmix64(uint64_t x)
{
    x += 0x9e3779b97f4a7c15ULL;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9ULL;
    x = (x ^ (x >> 27)) * 0x94d049bb133111ebULL;
    x = x ^ (x >> 31);
    return x;
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
    m->cap = cap;
    m->size = 0;
    m->keys = (uint64_t*)calloc(cap, sizeof(uint64_t));
    m->values = (int*)calloc(cap, sizeof(int));
    m->states = (unsigned char*)calloc(cap, sizeof(unsigned char));
}

static void cellmap_free(CellMap *m)
{
    free(m->keys);
    free(m->values);
    free(m->states);
    m->keys = NULL;
    m->values = NULL;
    m->states = NULL;
    m->cap = m->size = 0;
}

static void cellmap_rehash(CellMap *m, size_t new_cap)
{
    size_t cap = 8;
    while (cap < new_cap)
    {
        cap <<= 1;
    }

    uint64_t *old_keys = m->keys;
    int *old_values = m->values;
    unsigned char *old_states = m->states;
    size_t old_cap = m->cap;

    m->keys = (uint64_t*)calloc(cap, sizeof(uint64_t));
    m->values = (int*)calloc(cap, sizeof(int));
    m->states = (unsigned char*)calloc(cap, sizeof(unsigned char));
    m->cap = cap;
    m->size = 0;

    for (size_t i = 0; i < old_cap; ++i)
    {
        if (old_states[i] == 1)
        {
            uint64_t key = old_keys[i];
            int val = old_values[i];
            uint64_t h = splitmix64(key);
            size_t mask = m->cap - 1;
            size_t idx = (size_t)(h & mask);
            while (m->states[idx] == 1)
            {
                idx = (idx + 1) & mask;
            }
            m->states[idx] = 1;
            m->keys[idx] = key;
            m->values[idx] = val;
            m->size++;
        }
    }

    free(old_keys);
    free(old_values);
    free(old_states);
}

static void cellmap_maybe_grow(CellMap *m)
{
    if ((m->size + 1) * 10 >= m->cap * 7)
    {
        cellmap_rehash(m, m->cap << 1);
    }
}

static bool cellmap_get(CellMap *m, uint64_t key, int *out_val)
{
    size_t mask = m->cap - 1;
    uint64_t h = splitmix64(key);
    size_t idx = (size_t)(h & mask);
    while (1)
    {
        unsigned char st = m->states[idx];
        if (st == 0)
        {
            return false;
        }
        else if (st == 1 && m->keys[idx] == key)
        {
            if (out_val)
            {
                *out_val = m->values[idx];
            }
            return true;
        }
        else
        {
            idx = (idx + 1) & mask;
        }
    }
}

static void cellmap_set(CellMap *m, uint64_t key, int val)
{
    cellmap_maybe_grow(m);
    size_t mask = m->cap - 1;
    uint64_t h = splitmix64(key);
    size_t idx = (size_t)(h & mask);
    size_t first_del = (size_t)(-1);
    while (1)
    {
        unsigned char st = m->states[idx];
        if (st == 0)
        {
            size_t use_idx = (first_del != (size_t)(-1)) ? first_del : idx;
            m->states[use_idx] = 1;
            m->keys[use_idx] = key;
            m->values[use_idx] = val;
            m->size++;
            return;
        }
        else if (st == 2)
        {
            if (first_del == (size_t)(-1))
            {
                first_del = idx;
            }
            idx = (idx + 1) & mask;
        }
        else
        {
            if (m->keys[idx] == key)
            {
                m->values[idx] = val;
                return;
            }
            idx = (idx + 1) & mask;
        }
    }
}

static bool cellmap_del(CellMap *m, uint64_t key)
{
    size_t mask = m->cap - 1;
    uint64_t h = splitmix64(key);
    size_t idx = (size_t)(h & mask);
    while (1)
    {
        unsigned char st = m->states[idx];
        if (st == 0)
        {
            return false;
        }
        else if (st == 1 && m->keys[idx] == key)
        {
            m->states[idx] = 2;
            m->size--;
            return true;
        }
        else
        {
            idx = (idx + 1) & mask;
        }
    }
}

static inline uint64_t make_key(uint32_t row, uint32_t col)
{
    return (((uint64_t)row) << 32) | (uint64_t)col;
}

static bool parse_column_index(const char **ps, uint32_t *out_col)
{
    const char *s = *ps;
    if (!isalpha((unsigned char)*s))
    {
        return false;
    }
    uint64_t val = 0;
    while (isalpha((unsigned char)*s))
    {
        char c = toupper((unsigned char)*s);
        if (c < 'A' || c > 'Z')
        {
            return false;
        }
        val = val * 26u + (uint32_t)(c - 'A' + 1u);
        s++;
    }
    if (val == 0)
    {
        return false;
    }
    *out_col = (uint32_t)(val - 1u);
    *ps = s;
    return true;
}

static bool parse_uint(const char **ps, uint32_t *out_num)
{
    const char *s = *ps;
    if (!isdigit((unsigned char)*s))
    {
        return false;
    }
    uint64_t val = 0;
    while (isdigit((unsigned char)*s))
    {
        val = val * 10u + (uint32_t)(*s - '0');
        s++;
    }
    *out_num = (uint32_t)val;
    *ps = s;
    return true;
}

static void skip_spaces(const char **ps)
{
    const char *s = *ps;
    while (*s && isspace((unsigned char)*s))
    {
        s++;
    }
    *ps = s;
}

typedef struct
{
    Spreadsheet *ss;
    const char *s;
}
Parser;

static int parse_expr(Parser *p);

static int parse_factor(Parser *p)
{
    skip_spaces(&p->s);
    if (*p->s == '+')
    {
        p->s++;
        return parse_factor(p);
    }
    if (*p->s == '-')
    {
        p->s++;
        int v = parse_factor(p);
        return -v;
    }
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
        uint32_t row1based;
        if (parse_uint(&p->s, &row1based))
        {
            int row0 = (int)row1based - 1;
            int val = 0;
            if (row0 >= 0 && row0 < p->ss->rows)
            {
                uint64_t key = make_key((uint32_t)row0, col);
                if (!cellmap_get(&p->ss->map, key, &val))
                {
                    val = 0;
                }
            }
            else
            {
                val = 0;
            }
            return val;
        }
        else
        {
            p->s = start;
        }
    }
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
    if (!isdigit((unsigned char)*p->s))
    {
        return 0;
    }
    long long val = 0;
    while (isdigit((unsigned char)*p->s))
    {
        val = val * 10 + (*p->s - '0');
        p->s++;
    }
    if (neg)
    {
        val = -val;
    }
    return (int)val;
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
            if (rhs == 0)
            {
                v = 0;
            }
            else
            {
                v = v / rhs;
            }
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
    cellmap_init(&ss->map, 1024);
    return ss;
}

static bool parse_cell_ref(const char *cell, int max_rows, uint32_t *out_row0, uint32_t *out_col0)
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
    if (*s != '\0')
    {
        while (*s && isspace((unsigned char)*s))
        {
            s++;
        }
        if (*s != '\0')
        {
            return false;
        }
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
    if (!obj || !cell)
    {
        return;
    }
    uint32_t r0, c0;
    if (!parse_cell_ref(cell, obj->rows, &r0, &c0))
    {
        return;
    }
    uint64_t key = make_key(r0, c0);
    cellmap_set(&obj->map, key, value);
}

void spreadsheetResetCell(Spreadsheet* obj, char* cell)
{
    if (!obj || !cell)
    {
        return;
    }
    uint32_t r0, c0;
    if (!parse_cell_ref(cell, obj->rows, &r0, &c0))
    {
        return;
    }
    uint64_t key = make_key(r0, c0);
    cellmap_del(&obj->map, key);
}

int spreadsheetGetValue(Spreadsheet* obj, char* formula)
{
    if (!obj || !formula)
    {
        return 0;
    }
    const char *s = formula;
    while (*s && isspace((unsigned char)*s))
    {
        s++;
    }
    if (*s == '=')
    {
        s++;
        while (*s && isspace((unsigned char)*s))
        {
            s++;
        }
    }
    Parser p = { obj, s };
    int result = parse_expr(&p);
    return result;
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