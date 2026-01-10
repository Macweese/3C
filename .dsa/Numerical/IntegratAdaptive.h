/**
 * Author: Simon Lindholm
 * Date: 2015-02-11
 * License: CC0
 * Source: Wikipedia
 * Description: Fast integration using an adaptive Simpson's rule.
 * Usage:
 *     double sphereVolume = quad(-1, 1, [](double x) {
 *         return quad(-1, 1, [&](double y) {
 *             return quad(-1, 1, [&](double z) {
 *                 return x*x + y*y + z*z < 1;
 *             });
 *         });
 *     });
 * Status: mostly untested
 */
#pragma once

typedef double d;

// Simpson's rule approximation over interval [a,b]
#define SIMPSON(a, b) ((f(a) + 4 * f((a + b) / 2) + f(b)) * (b - a) / 6)

template <class F>
d rec(F& f, d a, d b, d eps, d whole)
{
    d c = (a + b) / 2;

    d left  = SIMPSON(a, c);
    d right = SIMPSON(c, b);
    d total = left + right;

    // Error estimate: if difference is small enough or interval tiny → accept
    if (abs(total - whole) <= 15 * eps || b - a < 1e-10)
    {
        // Improved final estimate (asymptotic error correction)
        return total + (total - whole) / 15;
    }

    // Recurse on both halves with half the tolerance
    return rec(f, a, c, eps / 2, left) +
           rec(f, c, b, eps / 2, right);
}

template <class F>
d quad(d a, d b, F f, d eps = 1e-8)
{
    if (a >= b) return 0.0;  // optional safety

    d initial = SIMPSON(a, b);
    return rec(f, a, b, eps, initial);
}
