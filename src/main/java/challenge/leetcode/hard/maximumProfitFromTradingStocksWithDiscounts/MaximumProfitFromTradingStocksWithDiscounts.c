#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
    int* data;
    int size;
    int capacity;
} IntArray;

void initArray(IntArray* arr)
{
    arr->capacity = 10;
    arr->size = 0;
    arr->data = (int*)malloc(arr->capacity * sizeof(int));
}

void pushArray(IntArray* arr, int val)
{
    if (arr->size >= arr->capacity)
    {
        arr->capacity *= 2;
        arr->data = (int*)realloc(arr->data, arr->capacity * sizeof(int));
    }
    arr->data[arr->size++] = val;
}

void freeArray(IntArray* arr)
{
    free(arr->data);
}

int** children;
int* childrenCount;
int* present;
int* future;
int globalBudget;
int*** memo;

void dfs(int node, int parentBought, int** dpOut, int* dpSize)
{
    if (memo[node][parentBought] != NULL)
    {
        *dpOut = memo[node][parentBought];
        *dpSize = (globalBudget + 1) * 2;
        return;
    }

    int* dp = (int*)malloc((globalBudget + 1) * sizeof(int));
    for (int i = 0; i <= globalBudget; i++)
    {
        dp[i] = -1;
    }
    dp[0] = 0;

    int cost = parentBought ? present[node - 1] / 2 : present[node - 1];
    int profit = future[node - 1] - cost;

    if (childrenCount[node] == 0)
    {
        if (cost <= globalBudget)
        {
            dp[cost] = profit;
        }
        memo[node][parentBought] = dp;
        *dpOut = dp;
        *dpSize = globalBudget + 1;
        return;
    }

    int** childDpNotBought = (int**)malloc(childrenCount[node] * sizeof(int*));
    int* childDpSizeNotBought = (int*)malloc(childrenCount[node] * sizeof(int));

    for (int i = 0; i < childrenCount[node]; i++)
    {
        dfs(children[node][i], 0, &childDpNotBought[i], &childDpSizeNotBought[i]);
    }

    int** childDpBought = (int**)malloc(childrenCount[node] * sizeof(int*));
    int* childDpSizeBought = (int*)malloc(childrenCount[node] * sizeof(int));

    for (int i = 0; i < childrenCount[node]; i++)
    {
        dfs(children[node][i], 1, &childDpBought[i], &childDpSizeBought[i]);
    }

    int* current = (int*)malloc((globalBudget + 1) * sizeof(int));
    for (int i = 0; i <= globalBudget; i++)
    {
        current[i] = -1;
    }
    current[0] = 0;

    for (int i = 0; i < childrenCount[node]; i++)
    {
        int* next = (int*)malloc((globalBudget + 1) * sizeof(int));
        for (int j = 0; j <= globalBudget; j++)
        {
            next[j] = -1;
        }

        for (int b1 = 0; b1 <= globalBudget; b1++)
        {
            if (current[b1] == -1) continue;

            for (int b2 = 0; b2 <= globalBudget - b1; b2++)
            {
                if (childDpNotBought[i][b2] == -1) continue;

                int totalBudget = b1 + b2;
                int totalProfit = current[b1] + childDpNotBought[i][b2];

                if (next[totalBudget] < totalProfit)
                {
                    next[totalBudget] = totalProfit;
                }
            }
        }

        free(current);
        current = next;
    }

    for (int b = 0; b <= globalBudget; b++)
    {
        if (current[b] > dp[b])
        {
            dp[b] = current[b];
        }
    }

    if (cost <= globalBudget)
    {
        int* buying = (int*)malloc((globalBudget + 1) * sizeof(int));
        for (int i = 0; i <= globalBudget; i++)
        {
            buying[i] = -1;
        }
        buying[0] = 0;

        for (int i = 0; i < childrenCount[node]; i++)
        {
            int* next = (int*)malloc((globalBudget + 1) * sizeof(int));
            for (int j = 0; j <= globalBudget; j++)
            {
                next[j] = -1;
            }

            for (int b1 = 0; b1 <= globalBudget - cost; b1++)
            {
                if (buying[b1] == -1) continue;

                for (int b2 = 0; b2 <= globalBudget - cost - b1; b2++)
                {
                    if (childDpBought[i][b2] == -1) continue;

                    int totalBudget = b1 + b2;
                    int totalProfit = buying[b1] + childDpBought[i][b2];

                    if (next[totalBudget] < totalProfit)
                    {
                        next[totalBudget] = totalProfit;
                    }
                }
            }

            free(buying);
            buying = next;
        }

        for (int b = 0; b <= globalBudget - cost; b++)
        {
            if (buying[b] != -1)
            {
                int totalBudget = b + cost;
                int totalProfit = buying[b] + profit;

                if (dp[totalBudget] < totalProfit)
                {
                    dp[totalBudget] = totalProfit;
                }
            }
        }

        free(buying);
    }

    free(current);
    free(childDpNotBought);
    free(childDpSizeNotBought);
    free(childDpBought);
    free(childDpSizeBought);

    memo[node][parentBought] = dp;
    *dpOut = dp;
    *dpSize = globalBudget + 1;
}

int maxProfit(int n, int* presentArr, int presentSize, int* futureArr, int futureSize, int** hierarchy, int hierarchySize, int* hierarchyColSize, int budget)
{
    present = presentArr;
    future = futureArr;
    globalBudget = budget;

    children = (int**)malloc((n + 1) * sizeof(int*));
    childrenCount = (int*)calloc(n + 1, sizeof(int));

    for (int i = 0; i <= n; i++)
    {
        children[i] = (int*)malloc(n * sizeof(int));
    }

    for (int i = 0; i < hierarchySize; i++)
    {
        int parent = hierarchy[i][0];
        int child = hierarchy[i][1];
        children[parent][childrenCount[parent]++] = child;
    }

    memo = (int***)malloc((n + 1) * sizeof(int**));
    for (int i = 0; i <= n; i++)
    {
        memo[i] = (int**)calloc(2, sizeof(int*));
    }

    int* dp;
    int dpSize;
    dfs(1, 0, &dp, &dpSize);

    int maxProfit = 0;
    for (int b = 0; b <= globalBudget; b++)
    {
        if (dp[b] > maxProfit)
        {
            maxProfit = dp[b];
        }
    }

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            if (memo[i][j] != NULL)
            {
                free(memo[i][j]);
            }
        }
        free(memo[i]);
        free(children[i]);
    }
    free(memo);
    free(children);
    free(childrenCount);

    return maxProfit;
}