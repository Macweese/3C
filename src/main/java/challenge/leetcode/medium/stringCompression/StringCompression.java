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

package challenge.leetcode.medium.stringCompression;

/**
 * @author Administrator
 * @Created 09:30 Tue 14 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class StringCompression
{
	public static int compress(char[] chars)
	{
		int n = chars.length;
		int index = 0;
		for (int i = 0; i < n; i++)
		{
			int count = 0;
			char c = chars[i];

			while (i < n && c == chars[i])
			{
				count++;
				i++;
			}

			chars[index++] = c;
			if (count != 1)
			{
				String str = String.valueOf(count);
				for (char digit : str.toCharArray())
				{
					chars[index++] = digit;
				}
			}
			i--;
		}

		return index;
	}
}
