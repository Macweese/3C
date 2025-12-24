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

package challenge.leetcode.medium.deleteColumnsToMakeSortedII;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @Created 08:36 Sun 21 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class DeleteColumnsToMakeSortedII
{
	public static int minDeletionSize(String[] strings)
	{
		int index = 0;
		Set<Integer> set = new HashSet<>();

		row: for (int i = 1; i < strings.length; i++)
		{
			if (strings[i - 1].charAt(0) == strings[i].charAt(index))
			{
				i--;
				index++;
				continue row;
			}
			else if (strings[i - 1].charAt(index) > strings[i].charAt(index))
			{
				set.add(index);
			}

			col: for (int j = 1; j < strings[i].length(); j++)
			{

			}
		}


		column: for (int i = 1; i < strings[0].length(); i++)
		{
			for (int row = 1; row < strings.length; row++)
			{
				if (strings[row - 1].charAt(i) > strings[row].charAt(i))
				{
					set.add(i);
					continue column;
				}
			}
		}

		return set.size();
	}
}
