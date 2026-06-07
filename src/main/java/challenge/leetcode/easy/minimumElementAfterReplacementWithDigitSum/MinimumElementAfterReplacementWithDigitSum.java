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

package challenge.leetcode.easy.minimumElementAfterReplacementWithDigitSum;

/**
 * @author Administrator
 * @Created 22:53 Fri 29 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumElementAfterReplacementWithDigitSum
{
	public static int minElement(int[] ints)
	{
		int d = Integer.MAX_VALUE;
		for (int i : ints)
		{
			d = Math.min(d, digitSum(i));
			if (d == 0)
			{
				break;
			}
		}

		return d;
	}

	public static int digitSum(int i)
	{
		int sum = 0;
		while (i > 0)
		{
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}
}
