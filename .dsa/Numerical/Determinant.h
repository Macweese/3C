/**
 * Author: Simon Lindholm
 * Date: 2016-09-06
 * License: CC0
 * Source: folklore
 * Description: Calculates determinant of a matrix. Destroys the matrix.
 * Time: O(N³)
 * Status: somewhat tested
 */
#pragma once

double det(vector<vector<double>>& a)
{
    int n = sz(a);
    double res = 1.0;

    rep(i, 0, n)
    {
        // Find pivot row
        int b = i;
        rep(j, i + 1, n)
        {
            if (fabs(a[j][i]) > fabs(a[b][i]))
            {
                b = j;
            }
        }

        // Swap rows if necessary
        if (i != b)
        {
            swap(a[i], a[b]);
            res *= -1;
        }

        // Multiply by pivot element
        res *= a[i][i];

        // Early exit if matrix is singular
        if (res == 0)
        {
            return 0;
        }

        // Eliminate below pivot
        rep(j, i + 1, n)
        {
            double v = a[j][i] / a[i][i];

            if (v != 0)
            {
                rep(k, i + 1, n)
                {
                    a[j][k] -= v * a[i][k];
                }
            }
        }
    }

    return res;
}
