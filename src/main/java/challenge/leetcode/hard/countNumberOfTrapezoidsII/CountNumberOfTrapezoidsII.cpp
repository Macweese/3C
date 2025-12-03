constexpr int BIAS = 1 << 11;

class Solution
{
public:
    long long countTrapezoids(vector<vector<int>>& points)
    {
        const int n = static_cast<int>(points.size());
        const int totalPairs = n * (n - 1);

        unordered_map<ll, int> lineCoefficientCount;
        unordered_map<ll, int> midpointWithSlopeCount;
        unordered_map<ll, int> slopeCount;
        unordered_map<ll, int> midpointCount;

        lineCoefficientCount.reserve(totalPairs);
        midpointWithSlopeCount.reserve(totalPairs);
        slopeCount.reserve(totalPairs);
        midpointCount.reserve(totalPairs);

        int trapezoidCount = 0;

        for (int i = 0; i < n - 1; ++i)
        {
            const int x0 = points[i][0];
            const int y0 = points[i][1];

            for (int j = i + 1; j < n; ++j)
            {
                const int x1 = points[j][0];
                const int y1 = points[j][1];

                int a = y1 - y0;
                int b = x0 - x1;
                int c = y0 * x1 - y1 * x0;

                if (a == 0 && b < 0)
                {
                    b = -b;
                    c = -c;
                }
                else if (a < 0)
                {
                    a = -a;
                    b = -b;
                    c = -c;
                }

                const int gcdAB = gcd(abs(a), abs(b));
                const int gcdABC = gcd(gcdAB, abs(c));

                const int normalizedAForSlope = a / gcdAB;
                const int normalizedBForSlope = b / gcdAB;

                const int normalizedAForLine = a / gcdABC;
                const int normalizedBForLine = b / gcdABC;
                const int normalizedCForLine = c / gcdABC;

                const ll slopeKey = pack2(normalizedAForSlope, normalizedBForSlope);
                const ll lineKey = pack3(normalizedAForLine, normalizedBForLine, normalizedCForLine);

                const ll midpointKey            = pack2(x0 + x1, y0 + y1);
                const ll midpointWithSlopeKey   = pack4(x0 + x1, y0 + y1, normalizedAForSlope, normalizedBForSlope);

                trapezoidCount += slopeCount[slopeKey]++;
                trapezoidCount -= lineCoefficientCount[lineKey]++;
                trapezoidCount -= midpointCount[midpointKey]++;
                trapezoidCount += midpointWithSlopeCount[midpointWithSlopeKey]++;
            }
        }

        return trapezoidCount;
    }

private:
    using ll = long long;

    static int pack2(int a, int b)
    {
        return ((ll)(a + BIAS) << 16) | (b + BIAS);
    }

    static ll pack3(int a, int b, int c)
    {
        return ((ll)(a + BIAS) << 50) |
               ((ll)(b + BIAS) << 30) |
               (c + BIAS * BIAS);
    }

    static ll pack4(int a, int b, int c, int d)
    {
        return ((ll)(a + BIAS) << 48) |
               ((ll)(b + BIAS) << 32) |
               ((ll)(c + BIAS) << 16) |
               (d + BIAS);
    }
};
