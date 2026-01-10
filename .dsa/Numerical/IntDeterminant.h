/**
 * Author:
 * Date: 2014-11-27
 * Source:
 * Description: Calculates determinant using modular arithmetics.
 *              Modulos can also be removed to get a pure-integer version.
 * Time: O(N³)
 * Status: bruteforce-tested for N <= 3, mod <= 7
 */
#pragma once

const ll mod = 12345;

ll det(vector<vector<ll>>& a)
{
    int n = sz(a);
    ll ans = 1;

    rep(i, 0, n)
    {
        // Find a non-zero pivot in column i (starting from row i)
        int pivot = i;
        rep(j, i, n)
        {
            if (a[j][i] != 0)
            {
                pivot = j;
                break;
            }
        }

        // If no pivot found → matrix is singular
        if (a[pivot][i] == 0)
        {
            return 0;
        }

        // Swap rows if necessary
        if (pivot != i)
        {
            swap(a[i], a[pivot]);
            ans = -ans;
        }

        ll piv = a[i][i];

        ans = ans * piv % mod;
        if (ans == 0)
        {
            return 0;
        }

        // Eliminate below current pivot (using integer division)
        rep(j, i + 1, n)
        {
            while (a[j][i] != 0)
            {
                ll t = a[i][i] / a[j][i];   // Note: integer division

                if (t != 0)
                {
                    rep(k, i, n)
                    {
                        a[i][k] = (a[i][k] - a[j][k] * t) % mod;
                    }
                }

                swap(a[i], a[j]);
                ans = -ans;
            }
        }
    }

    return (ans + mod) % mod;
}
