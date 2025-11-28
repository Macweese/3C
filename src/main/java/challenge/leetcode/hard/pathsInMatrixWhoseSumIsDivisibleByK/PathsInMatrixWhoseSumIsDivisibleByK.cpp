class Solution
{
public:
    static int numberOfPaths(vector<vector<int>>& matrix, int k)
    {
        const int m = matrix.size(), n = matrix[0].size();
        const int mod = 1e9 + 7;
        int dp[2][n][k];

        memset(dp, 0, sizeof(dp));
        const int origin = matrix[0][0];

        for (int r = 0; r < k; r++)
        {
            dp[0][0][r] = (origin + r) % k == 0;
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                const int x = matrix[i][j];
                for (int r = 0; r < k; r++)
                {
                    const int R0 = (r + x) % k;
                    if (i > 0)
                    {
                        dp[i & 1][j][r] = dp[(i - 1) & 1][j][R0];
                    }

                    if (j > 0)
                    {
                        dp[i & 1][j][r] += dp[i & 1][j - 1][R0];
                    }

                    dp[i & 1][j][r] %= mod;
                }
            }
        }
        return dp[(m - 1) & 1][n - 1][0];
    }
};
