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

package challenge.leetcode.hard.lexicographicallySmallestGeneratedString;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 07:01 Tue 31 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class LexicographicallySmallestGeneratedString
{
	public static String generateString(String s, String t)
	{
		int n = s.length();
		int m = t.length();
		char[] ans = new char[n + m - 1];
		boolean[] fixed = new boolean[n + m - 1];

		Arrays.fill(ans, 'a');

		for (int i = 0; i < n; i++)
		{
			if (s.charAt(i) != 'T')
			{
				continue;
			}

			for (int j = 0; j < m; j++)
			{
				int k = i + j;
				if (fixed[k] && ans[k] != t.charAt(j))
				{
					return "";
				}
				ans[k] = t.charAt(j);
				fixed[k] = true;
			}
		}

		for (int i = 0; i < n; i++)
		{
			if (s.charAt(i) != 'F')
			{
				continue;
			}

			boolean same = true;
			for (int j = 0; j < m; j++)
			{
				if (ans[i + j] != t.charAt(j))
				{
					same = false;
					break;
				}
			}

			if (!same)
			{
				continue;
			}

			boolean ok = false;
			for (int j = i + m - 1; j >= i; j--)
			{
				if (!fixed[j])
				{
					ans[j] = 'b';
					ok = true;
					break;
				}
			}

			if (!ok)
			{
				return "";
			}
		}

		return new String(ans);
	}
}
