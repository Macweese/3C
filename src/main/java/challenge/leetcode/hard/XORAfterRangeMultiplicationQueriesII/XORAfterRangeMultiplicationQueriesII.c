#include <stdlib.h>
#include <string.h>

#define MOD 1000000007

typedef long long ll;

ll mod_pow(ll base, ll exp)
{
    ll result = 1;
    base %= MOD;
    while (exp > 0)
    {
        if (exp & 1)
        {
            result = result * base % MOD;
        }
        base = base * base % MOD;
        exp >>= 1;
    }
    return result;
}

int xorAfterQueries(int* nums, int numsSize, int** queries, int queriesSize, int* queriesColSize)
{
    int n = numsSize;
    int B = 1;
    while (B * B <= n)
    {
        B++;
    }

    ll* arr = (ll*)malloc(n * sizeof(ll));
    for (int i = 0; i < n; i++)
    {
        arr[i] = nums[i];
    }

    int** groups = (int**)malloc(B * sizeof(int*));
    int* groupSize = (int*)calloc(B, sizeof(int));
    int* groupCap = (int*)malloc(B * sizeof(int));
    for (int i = 0; i < B; i++)
    {
        groupCap[i] = 16;
        groups[i] = (int*)malloc(groupCap[i] * 3 * sizeof(int));
    }

    for (int i = 0; i < queriesSize; i++)
    {
        int l = queries[i][0];
        int r = queries[i][1];
        int k = queries[i][2];
        int v = queries[i][3];

        if (k >= B)
        {
            for (int idx = l; idx <= r; idx += k)
            {
                arr[idx] = arr[idx] * v % MOD;
            }
        }
        else
        {
            if (groupSize[k] >= groupCap[k])
            {
                groupCap[k] *= 2;
                groups[k] = (int*)realloc(groups[k], groupCap[k] * 3 * sizeof(int));
            }
            int base = groupSize[k] * 3;
            groups[k][base] = l;
            groups[k][base + 1] = r;
            groups[k][base + 2] = v;
            groupSize[k]++;
        }
    }

    ll* diff = (ll*)malloc((n + B) * sizeof(ll));

    for (int k = 1; k < B; k++)
    {
        if (groupSize[k] == 0)
        {
            continue;
        }

        for (int i = 0; i < n + B; i++)
        {
            diff[i] = 1;
        }

        for (int i = 0; i < groupSize[k]; i++)
        {
            int l = groups[k][i * 3];
            int r = groups[k][i * 3 + 1];
            int v = groups[k][i * 3 + 2];

            diff[l] = diff[l] * v % MOD;

            int last = l + ((r - l) / k) * k;
            int nxt = last + k;
            ll inv_v = mod_pow(v, MOD - 2);
            diff[nxt] = diff[nxt] * inv_v % MOD;
        }

        for (int start = 0; start < k; start++)
        {
            for (int i = start + k; i < n; i += k)
            {
                diff[i] = diff[i] * diff[i - k] % MOD;
            }
        }

        for (int i = 0; i < n; i++)
        {
            arr[i] = arr[i] * diff[i] % MOD;
        }
    }

    int result = 0;
    for (int i = 0; i < n; i++)
    {
        result ^= (int)arr[i];
    }

    free(arr);
    free(diff);
    for (int i = 0; i < B; i++)
    {
        free(groups[i]);
    }
    free(groups);
    free(groupSize);
    free(groupCap);

    return result;
}