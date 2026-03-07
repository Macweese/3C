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

package challenge.leetcode.medium.minimumNumberOfFlipsToMakeTheBinaryStringAlternating;

/**
 * @author Administrator
 * @Created 07:01 Sat 07 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating
{
	public static int minFlips(String s)
	{
		int n = s.length();
		String string = s + s;

		int a = 0;
		int b = 0;

		for (int i = 0; i < n; i++)
		{
			char expected1 = (i % 2 == 0) ? '0' : '1';
			char expected2 = (i % 2 == 0) ? '1' : '0';

			if (string.charAt(i) != expected1)
			{
				a++;
			}
			if (string.charAt(i) != expected2)
			{
				b++;
			}
		}

		int flips = Math.min(a, b);

		for (int i = n; i < 2 * n; i++)
		{
			char c1 = (i % 2 == 0) ? '0' : '1';
			char c2 = (i % 2 == 0) ? '1' : '0';

			if (string.charAt(i) != c1)
			{
				a++;
			}
			if (string.charAt(i) != c2)
			{
				b++;
			}

			char prev1 = ((i - n) % 2 == 0) ? '0' : '1';
			char prev2 = ((i - n) % 2 == 0) ? '1' : '0';

			if (string.charAt(i - n) != prev1)
			{
				a--;
			}
			if (string.charAt(i - n) != prev2)
			{
				b--;
			}

			flips = Math.min(flips, Math.min(a, b));
		}

		return flips;
	}
}

