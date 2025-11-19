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

package challenge.leetcode.medium.findTriangularSumOfAnArray;

/**
 * @author Administrator
 * @Created 30/09/2025, 23:09 Tue 30 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class FindTriangularSumOfAnArray
{
	public static int triangularSum(int[] nums)
	{
		if (nums.length == 1)
		{
			return nums[0];
		}

		int[] ints = new int[nums.length - 1];

		for (int i = 1; i < nums.length; i++)
		{
			ints[i - 1] = (nums[i - 1] + nums[i]) % 10;
		}

		return triangularSum(ints);
	}
}
