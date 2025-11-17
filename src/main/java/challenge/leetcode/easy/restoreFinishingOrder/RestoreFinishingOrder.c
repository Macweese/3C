#include <stdio.h>
#include <stdlib.h>

int compareInts(const void* a, const void* b)
{
    int ia = *(const int*)a;
    int ib = *(const int*)b;
    return (ia > ib) - (ia < ib);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* recoverOrder(int* order, int orderSize, int* friends, int friendsSize, int* returnSize)
{
    int* sorted = (int*)malloc(orderSize * sizeof(int));
    if (sorted == NULL)
    {
        *returnSize = 0;
        return NULL;
    }

    int index = 0;

    for (int i = 0; i < orderSize; i++)
    {
        int* found = (int*)bsearch(&order[i], friends, friendsSize, sizeof(int), compareInts);
        if (found != NULL)
        {
            sorted[index++] = order[i];
        }
    }

    if (index == 0)
    {
        free(sorted);
        *returnSize = 0;
        return NULL;
    }

    int* resized = (int*)realloc(sorted, index * sizeof(int));
    if (resized != NULL)
    {
        sorted = resized;
    }

    *returnSize = index;
    return sorted;
}