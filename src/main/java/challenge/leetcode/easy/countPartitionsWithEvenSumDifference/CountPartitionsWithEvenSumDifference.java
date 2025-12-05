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

package challenge.leetcode.easy.countPartitionsWithEvenSumDifference;

/**
 * @author Administrator
 * @Created 01:01 Fri 05 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountPartitionsWithEvenSumDifference
{
	static void main()
	{
		countPartitions(new int[]{1,2,2});
	}
	public static int countPartitions(int[] ints)
	{
		int sum = 0;
		for (int i : ints)
		{
			sum += i;
		}
		return (sum & 1) == 1 ? 0 : ints.length - 1;
	}
}
