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

package challenge.leetcode.medium.checkIfStringsCanBeMadeEqualWithOperationsII;

/**
 * @author Administrator
 * @Created 07:05 Mon 30 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CheckIfStringsCanBeMadeEqualWithOperationsII
{
	public static boolean checkStrings(String s1, String s2)
	{
		int[][] cnt = new int[2][26];

		for (int i = 0; i < s1.length(); i++)
		{
			cnt[i & 1][s1.charAt(i) - 'a']++;
			cnt[i & 1][s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++)
		{
			if (cnt[0][i] != 0 || cnt[1][i] != 0)
			{
				return false;
			}
		}

		return true;
	}
}
