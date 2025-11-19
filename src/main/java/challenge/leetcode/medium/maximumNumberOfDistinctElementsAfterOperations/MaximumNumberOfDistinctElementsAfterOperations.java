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

package challenge.leetcode.medium.maximumNumberOfDistinctElementsAfterOperations;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 18/10/2025, 09:00 Sat 18 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class MaximumNumberOfDistinctElementsAfterOperations
{
	public static int maxDistinctElements(int[] ints, int k)
	{
		Arrays.sort(ints);
		int count = 0;
		int previous = Integer.MIN_VALUE;

		for (int i : ints)
		{
			int next = Math.max(i - k, previous + 1);
			if (next <= i + k)
			{
				previous = next;
				count++;
			}
		}

		return count;
	}
}
