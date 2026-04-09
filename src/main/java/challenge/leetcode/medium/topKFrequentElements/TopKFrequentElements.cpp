/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

// bucket sort
class Solution
{
public:
    vector<int> topKFrequent(vector<int>& nums, int k)
    {
        unordered_map<int, int> freq;
        for (int num : nums)
        {
            freq[num]++;
        }

        vector<vector<int>> buckets(nums.size() + 1);
        for (auto& p : freq)
        {
            buckets[p.second].push_back(p.first);
        }

        vector<int> res;
        for (int i = buckets.size() - 1; i >= 0 && res.size() < k; i--)
        {
            for (int num : buckets[i])
            {
                res.push_back(num);
                if (res.size() == k)
                {
                	break;
                }
            }
        }

        return res;
    }
};