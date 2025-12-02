class Solution
{
public:
    static int countTrapezoids(vector<vector<int>>& points)
    {
        const long long MOD = 1e9 + 7;
        const long long numPoints = points.size();

        int* yCoordinates = (int*)alloca(numPoints * sizeof(int));
        int index = 0;

        for (auto& point : points)
        {
            yCoordinates[index++] = point[1];
        }

        std::sort(yCoordinates, yCoordinates + numPoints);

        long long totalPairs = 0;  // sum of C(count, 2) over all y-groups
        long long sumOfSquares = 0;  // sum of C(count, 2)^2 over all y-groups
        long long currentGroupSize = 1;
        int previousY = yCoordinates[0];

        for (int i = 1; i < numPoints; ++i)
        {
            int currentY = yCoordinates[i];

            if (currentY == previousY)
            {
                ++currentGroupSize;
            }
            else
            {
                long long pairsInGroup = currentGroupSize * (currentGroupSize - 1LL) / 2LL;
                totalPairs += pairsInGroup;
                sumOfSquares += pairsInGroup * pairsInGroup;

                currentGroupSize = 1;
                previousY = currentY;
            }
        }

        // Process the last group
        long long pairsInLastGroup = currentGroupSize * (currentGroupSize - 1LL) / 2LL;
        totalPairs += pairsInLastGroup;
        sumOfSquares += pairsInLastGroup * pairsInLastGroup;

        // Formula: (totalPairs^2 - sumOfSquares) / 2
        long long numerator = totalPairs * totalPairs - sumOfSquares;
        long long result = numerator / 2;

        return static_cast<int>(result % MOD);
    }
};
