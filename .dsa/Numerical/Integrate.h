/**
 * Author: Simon Lindholm
 * Date: 2015-02-11
 * License: CC0
 * Source: Wikipedia
 * Description: Simple integration of a function over an interval using
 *              Simpson's rule. The error should be proportional to h⁴,
 *              although in practice you will want to verify that the result
 *              is stable to desired precision when epsilon changes.
 * Status: mostly untested
 */
#pragma once

template<class F>
double quad(double a, double b, F f, const int n = 1000)
{
    double h = (b - a) / (2.0 * n);
    double v = f(a) + f(b);

    rep(i, 1, n * 2)
    {
        double weight = (i & 1) ? 4.0 : 2.0;
        v += f(a + i * h) * weight;
    }

    return v * h / 3.0;
}
