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

package challenge.leetcode.easy.checkIfAll1sAreAtLeastLengthKPlacesAway;

/**
 * @author Administrator
 * @Created 17/11/2025, 01:07 Mon 17 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class CheckIfAll1sAreAtLeastLengthKPlacesAway
{
	public static boolean kLengthApart(int[] ints, int k)
	{
		int prev = 0;
		boolean first = true;
		for (int i = 0; i < ints.length; i++)
		{
			if (ints[i] == 1)
			{
				if (first)
				{
					prev = i;
					first = false;
					continue;
				}
				if (i - prev <= k)
				{
					return false;
				}
				prev = i;
			}
		}
		return true;
	}
}
