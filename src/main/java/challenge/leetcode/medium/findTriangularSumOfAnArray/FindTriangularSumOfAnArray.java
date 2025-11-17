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
	static void main(String[] args)
	{
		int[] TEST_1 = new int[]{5};
		int[] TEST_2 = new int[]{3,7};
		int[] TEST_3 = new int[]{9,9,9,9,9};
		int[] TEST_4 = new int[]{0,0,0,0,0,0};
		int[] TEST_5 = new int[]{1,2,3,4,5,6,7,8,9};
		int[] TEST_6 = new int[]{9,0,9,0,9,0,9,0,9,0};
		int[] TEST_7 = new int[]{8,7,6,5,4,3,2,1};
		int[] TEST_8 = new int[]{1,1,1,1,1,1,1,1,1,1};

		System.out.println(triangularSum(TEST_1));
		System.out.println(triangularSum(TEST_2));
		System.out.println(triangularSum(TEST_3));
		System.out.println(triangularSum(TEST_4));
		System.out.println(triangularSum(TEST_5));
		System.out.println(triangularSum(TEST_6));
		System.out.println(triangularSum(TEST_7));
		System.out.println(triangularSum(TEST_8));
	}

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
