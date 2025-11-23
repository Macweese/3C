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

package challenge.leetcode.medium.greatestSumDivisibleByThree;

/**
 * @author Administrator
 * @Created 01:52 Sun 23 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class GreatestSumDivisibleByThree
{
	public static int maxSumDivThree(int[] ints)
	{
		int sum = 0;
		int smallestRemainder1 = (int) (1e9 + 7);
		int smallestRemainder2 = (int) (1e9 + 7);

		for (int i : ints)
		{
			sum += i;
			if (i % 3 == 1)
			{
				smallestRemainder2 = Math.min(smallestRemainder2, i + smallestRemainder1);
				smallestRemainder1 = Math.min(smallestRemainder1, i);
			}
			if (i % 3 == 2)
			{
				smallestRemainder1 = Math.min(smallestRemainder1, i + smallestRemainder2);
				smallestRemainder2 = Math.min(smallestRemainder2, i);
			}
		}

		switch (sum % 3)
		{
			//CHECKSTYLE:OFF
			case 1: return sum - smallestRemainder1;
			case 2: return sum - smallestRemainder2;
			default: return sum;
			//CHECKSTYLE:ON
		}
	}

	public static int dpSolution(int[] nums)
	{
		int[] dp = new int[3];
		dp[0] = 0;
		dp[1] = Integer.MIN_VALUE;
		dp[2] = dp[1];
		for (int val : nums)
		{
			int[] curr = dp.clone();
			for (int i = 0; i < 3; i++)
			{
				int remainder = (i + val) % 3;
				curr[remainder] = Math.max(curr[remainder], dp[i] + val);
			}
			dp = curr;
		}
		return dp[0];
	}
}
