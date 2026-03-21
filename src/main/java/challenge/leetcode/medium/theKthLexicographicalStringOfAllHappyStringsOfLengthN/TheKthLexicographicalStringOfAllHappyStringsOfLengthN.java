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

package challenge.leetcode.medium.theKthLexicographicalStringOfAllHappyStringsOfLengthN;

/**
 * @author Administrator
 * @Created 07:10 Sat 14 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN
{
	private static String result;
	private static int count;

	public static String getHappyString(int n, int k)
	{
		result = "";
		count = 0;
		backtrack(new StringBuilder(), n, k);
		return result;
	}

	private static void backtrack(StringBuilder current, int n, int k)
	{
		if (current.length() == n)
		{
			count++;
			if (count == k)
			{
				result = current.toString();
			}
			return;
		}

		if (!result.isEmpty())
		{
			return;
		}

		char[] chars = {'a', 'b', 'c'};
		for (char c : chars)
		{
			if (current.length() == 0 || current.charAt(current.length() - 1) != c)
			{
				current.append(c);
				backtrack(current, n, k);
				current.deleteCharAt(current.length() - 1);
			}
		}
	}
}
