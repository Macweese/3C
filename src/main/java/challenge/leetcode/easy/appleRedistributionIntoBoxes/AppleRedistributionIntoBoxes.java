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

package challenge.leetcode.easy.appleRedistributionIntoBoxes;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 05:36 Wed 24 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class AppleRedistributionIntoBoxes
{
	public static int minimumBoxes(int[] apple, int[] capacity)
	{
		int apples = 0;
		for (int a : apple)
		{
			apples += a;
		}

		Arrays.sort(capacity);
		int boxesRequired = 0;
		int nextLargestBox = capacity.length - 1;

		while (apples > 0)
		{
			apples -= capacity[nextLargestBox--];
			boxesRequired++;
		}

		return boxesRequired;
	}
}
