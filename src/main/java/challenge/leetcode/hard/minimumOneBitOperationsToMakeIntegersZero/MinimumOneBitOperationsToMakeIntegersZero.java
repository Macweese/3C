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

package challenge.leetcode.hard.minimumOneBitOperationsToMakeIntegersZero;

/**
 * @author Administrator
 * @Created 08/11/2025, 23:22 Sat 08 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class MinimumOneBitOperationsToMakeIntegersZero
{
	static void main(String[] args)
	{
		System.out.println(minimumOneBitOperations(15));
		System.out.println(minimumOneBitOperations(8));
	}

	public static int minimumOneBitOperations(int n)
	{
		System.out.println();
		int k = (int) (Math.log(n) / Math.log(2)) + 1;
		Integer.highestOneBit(n);

		System.out.println(Integer.toBinaryString(n));
		int r = Integer.highestOneBit(n) ^ n;
		System.out.println(Integer.toBinaryString(r));

		return (int) Math.pow(2, k) - 1;
	}
}
