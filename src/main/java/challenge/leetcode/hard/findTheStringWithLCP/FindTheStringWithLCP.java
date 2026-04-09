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

package challenge.leetcode.hard.findTheStringWithLCP;

/**
 * @author Administrator
 * @Created 06:59 Sat 28 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class FindTheStringWithLCP
{
	public static String findTheString(int[][] lcp)
	{
		int n = lcp.length;
		char[] word = new char[n];
		char currentChar = 'a';

		for (int i = 0; i < n; i++)
		{
			if (word[i] == '\0')
			{
				if (currentChar > 'z')
				{
					return "";
				}

				word[i] = currentChar;

				for (int j = i + 1; j < n; j++)
				{
					if (lcp[i][j] > 0)
					{
						word[j] = currentChar;
					}
				}

				currentChar++;
			}
		}

		for (int i = n - 1; i >= 0; i--)
		{
			for (int j = n - 1; j >= 0; j--)
			{
				int expectedLcp;

				if (word[i] != word[j])
				{
					expectedLcp = 0;
				}
				else
				{
					expectedLcp = (i + 1 < n && j + 1 < n) ? lcp[i + 1][j + 1] + 1 : 1;
				}

				if (lcp[i][j] != expectedLcp)
				{
					return "";
				}
			}
		}

		return new String(word);
	}
}
