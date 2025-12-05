class Solution
{
public:
    int countCollisions(string directions)
    {
        int length = directions.size();
        if (length <= 1)
        {
            return 0;
        }

        int left = 0;
        int right = length - 1;

        while (left < length && directions[left] == 'L')
        {
            left++;
        }

        while (right >= 0 && directions[right] == 'R')
        {
            right--;
        }

        if (left >= right)
        {
            return 0;
        }

        int collisions = 0;

        for (; left <= right; left++)
        {
            if (directions[left] == 'R')
            {
                while (left <= right && directions[left] == 'R')
                {
                    left++;
                	collisions++;
                }
                left--;
            }
            else if (directions[left] == 'L')
            {
                collisions++;
            }
        }

        return collisions;
    }
};

auto init = []()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 0;
}();