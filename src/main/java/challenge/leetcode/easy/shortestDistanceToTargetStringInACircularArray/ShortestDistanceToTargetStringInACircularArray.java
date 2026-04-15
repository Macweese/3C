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

package challenge.leetcode.easy.shortestDistanceToTargetStringInACircularArray;

/**
 * @author Administrator
 * @Created 06:33 Wed 15 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class ShortestDistanceToTargetStringInACircularArray
{
	public static int closestTarget(String[] words, String target, int start)
	{
		for (int i = 0, n = words.length; i <= (n >> 1); ++i)
		{
			if (target.equals(words[(start + i) % n]) || target.equals(words[(start - i + n) % n]))
			{
				return i;
			}
		}

		return -1;
	}
}
