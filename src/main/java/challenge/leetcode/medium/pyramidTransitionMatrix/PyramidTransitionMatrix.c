/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char blocks[7];
    int count;
} Mapping;

typedef struct
{
    Mapping map[7][7];
} TransitionMap;

typedef struct Node
{
    char key[16];
    bool value;
    struct Node* next;
} Node;

typedef struct
{
    Node* buckets[1024];
} MemoMap;

unsigned int hash(char* str)
{
    unsigned int h = 5381;
    while (*str)
    {
        h = ((h << 5) + h) + *str++;
    }
    return h & 1023;
}

bool getMemo(MemoMap* memo, char* str, bool* result)
{
    unsigned int h = hash(str);
    Node* node = memo->buckets[h];

    while (node)
    {
        if (strcmp(node->key, str) == 0)
        {
            *result = node->value;
            return true;
        }
        node = node->next;
    }
    return false;
}

void setMemo(MemoMap* memo, char* str, bool val)
{
    unsigned int h = hash(str);
    Node* node = (Node*)malloc(sizeof(Node));
    strcpy(node->key, str);
    node->value = val;
    node->next = memo->buckets[h];
    memo->buckets[h] = node;
}

void freeMemo(MemoMap* memo)
{
    for (int i = 0; i < 1024; i++)
    {
        Node* node = memo->buckets[i];
        while (node)
        {
            Node* temp = node;
            node = node->next;
            free(temp);
        }
    }
}

void buildMap(TransitionMap* tm, char** allowed, int allowedSize)
{
    memset(tm, 0, sizeof(TransitionMap));

    for (int i = 0; i < allowedSize; i++)
    {
        int left = allowed[i][0] - 'A';
        int right = allowed[i][1] - 'A';
        char top = allowed[i][2];

        tm->map[left][right].blocks[tm->map[left][right].count++] = top;
    }
}

bool dfs(char* current, int currentLen, TransitionMap* tm, MemoMap* memo)
{
    if (currentLen == 1)
    {
        return true;
    }

    bool cached;
    if (getMemo(memo, current, &cached))
    {
        return cached;
    }

    char* next = (char*)malloc(currentLen);

    bool result = false;
    int nextLen = currentLen - 1;

    bool canBuild(int pos)
    {
        if (pos == nextLen)
        {
            next[pos] = '\0';
            if (dfs(next, nextLen, tm, memo))
            {
                return true;
            }
            return false;
        }

        int left = current[pos] - 'A';
        int right = current[pos + 1] - 'A';
        Mapping* m = &tm->map[left][right];

        if (m->count == 0)
        {
            return false;
        }

        for (int i = 0; i < m->count; i++)
        {
            next[pos] = m->blocks[i];
            if (canBuild(pos + 1))
            {
                return true;
            }
        }

        return false;
    }

    result = canBuild(0);

    free(next);
    setMemo(memo, current, result);
    return result;
}

bool pyramidTransition(char* bottom, char** allowed, int allowedSize)
{
    TransitionMap tm;
    buildMap(&tm, allowed, allowedSize);

    MemoMap memo;
    memset(&memo, 0, sizeof(MemoMap));

    bool result = dfs(bottom, strlen(bottom), &tm, &memo);

    freeMemo(&memo);
    return result;
}