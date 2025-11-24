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

package challenge.leetcode.easy.binaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 01:03 Mon 24 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class BinaryPrefixDivisibleBy5
{
	public static List<Boolean> prefixesDivBy5(int[] ints)
	{
		List<Boolean> result = new ArrayList<>();
		int number = 0;
		for (int i : ints)
		{
			number = ((number << 1) + i) % 5;
			result.add(number % 5 == 0);
		}
		return result;
	}
}
