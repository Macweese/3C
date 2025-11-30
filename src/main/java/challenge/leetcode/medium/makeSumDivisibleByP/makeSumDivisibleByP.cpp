class Solution
{
public:
    static int array_method(int n, int modP, vector<int>& nums, int p)
    {
        vector<int> pos(p, INT_MAX);
        pos[0] = -1;
        int len = n;
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            sum = (sum + nums[i]) % p;
            int y = (sum - modP + p) % p;
            if (pos[y] != INT_MAX)
            {
                len = min(len, i - pos[y]);
            }
            pos[sum] = i;
        }
        return (len == n) ? -1 : len;
    }

    static int minSubarray(vector<int>& nums, int p)
    {
        const int n = nums.size();
        int modP = 0;

        for (int x : nums)
        {
            modP = (modP + x) % p;
        }

        // cout << modP << endl;
        if (modP == 0)
        {
            return 0;
        }

        int sz = min(n, p);
        if (p <= 100000)
        {
            return array_method(n, modP, nums, p);
        }

        unordered_map<int, int> pos = { {0, -1} };
        pos.reserve(sz);

        int len = n;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum = (sum + nums[i]) % p;
            int y = (sum - modP + p) % p;
            if (pos.count(y))
            {
                len = min(len, i - pos[y]);
            }
            pos[sum] = i;
        }
        return (len == n) ? -1 : len;
    }
};

auto init = []()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();
