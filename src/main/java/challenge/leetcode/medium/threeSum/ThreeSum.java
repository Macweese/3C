/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
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
package challenge.leetcode.medium.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Created 
 * @Project 3C: Competitive Coding Challenges
 **/
public class ThreeSum
{
	public static List<List<Integer>> threeSum(int[] nums, int sum)
	{
		List<List<Integer>> ans = new ArrayList<>();

		// Sort the array
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++)
		{
			// Skip duplicate elements for i
			if (i > 0 && nums[i] == nums[i - 1])
			{
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k)
			{
				int total = nums[i] + nums[j] + nums[k];

				if (total == sum)
				{
					// Found a triplet with for sum
					ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

					// Skip duplicate elements for j
					while (j < k && nums[j] == nums[j + 1])
					{
						j++;
					}

					// Skip duplicate elements for k
					while (j < k && nums[k] == nums[k - 1])
					{
						k--;
					}

					// Move the pointers
					j++;
					k--;
				}
				else if (sum < 0)
				{
					// Sum is less than zero, increment j to increase the sum
					j++;
				}
				else
				{
					// Sum is greater than zero, decrement k to decrease the sum
					k--;
				}
			}
		}
		return ans;
	}
}
