/**
 * Author: Lucian Bicsi
 * Date: 2015-06-25
 * License: GNU Free Documentation License 1.2
 * Source: csacademy
 * Description: Transform to a basis with fast convolutions of the form
 *              c[z] = \sum_{z = x \oplus y} a[x] \cdot b[y],
 *              where \oplus is one of AND, OR, XOR. The size of a must be a power of two.
 * Time: O(N log N)
 * Status: stress-tested
 */
#pragma once

void FST(vi& a, bool inv)
{
    for (int n = sz(a), step = 1; step < n; step *= 2)
    {
        for (int i = 0; i < n; i += 2 * step)
        {
            rep(j, i, i + step)
            {
                int& u = a[j];
                int& v = a[j + step];

                // AND convolution
                tie(u, v) = inv ? pii(v - u, u) : pii(v, u + v);

                // OR convolution (uncomment to use)
                // tie(u, v) = inv ? pii(v, u - v) : pii(u + v, u);

                // XOR convolution (uncomment to use)
                // tie(u, v) = pii(u + v, u - v);
            }
        }
    }

    // Only needed for XOR convolution when doing inverse transform
    // if (inv) for (int& x : a) x /= sz(a);
}

vi conv(vi a, vi b)
{
    FST(a, false);    // forward transform
    FST(b, false);

    rep(i, 0, sz(a))
    {
        a[i] *= b[i];
    }

    FST(a, true);     // inverse transform
    return a;
}
