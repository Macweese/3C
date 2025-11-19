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

package challenge.leetcode.easy.keepMultiplyingFoundValuesByTwo;

import java.util.HashSet;

/**
 * @author Administrator
 * @Created 02:01 Wed 19 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class KeepMultiplyingFoundValuesByTwo
{
	public static int findFinalValue(int[] ints, int val)
	{
		HashSet<Integer> set = new HashSet<>();
		for (int i : ints)
		{
			set.add(i);
			val += val & ~((i ^ val >> 31) | ((-(i ^ val)) >> 31));
		}
		while (set.contains(val))
		{
			val <<= 1;
		}
		return val;
	}
}
