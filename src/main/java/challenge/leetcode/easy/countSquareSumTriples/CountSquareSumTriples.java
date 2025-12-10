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

package challenge.leetcode.easy.countSquareSumTriples;

import java.util.HashSet;

/**
 * @author Administrator
 * @Created 11:24 Mon 08 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountSquareSumTriples
{
	public static int countTriples(int n)
	{
		int count = 0;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 5; i <= n; i++)
		{
			set.add(i * i);
		}

		for (int a = 3; a < n; a++)
		{
			for (int b = a + 1; b < n; b++)
			{
				int x = (a * a + b * b);
				if (set.contains(x))
				{
					count += 2;
				}
			}
		}

		return count;
	}
}
