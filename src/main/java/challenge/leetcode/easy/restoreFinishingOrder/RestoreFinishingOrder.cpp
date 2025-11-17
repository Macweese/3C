class Solution
{
public:
    std::vector<int> recoverOrder(const std::vector<int>& order, const std::vector<int>& friends)
    {
        int index = 0;
        std::vector<int> sorted(friends.size());

        for (int i : order)
        {
            int j = binarySearch(friends, i);
            if (j != -1 && i == friends[j])
            {
                sorted[index++] = i;
            }
        }

        sorted.resize(index);
        return sorted;
    }

private:
    int binarySearch(const std::vector<int>& ints, int value)
    {
        int l = 0;
        int r = static_cast<int>(ints.size()) - 1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (ints[m] == value)
            {
                return m;
            }

            if (ints[m] < value)
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }

        return -1;
    }
};