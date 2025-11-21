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

package challenge.leetcode.medium.uniqueLength3PalindromicSequences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @Created 01:13 Fri 21 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class UniqueLength3PalindromicSequences
{
	private static final int ALPHABET_SIZE = 26;

	public static int countPalindromicSubsequence(String s)
	{
		int count = 0;
		Set<Character> left = new HashSet<>();
		Map<Character, Integer> right = new HashMap<>();
		boolean[][] seen = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];

		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			right.put(c, right.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s.length() - 1; i++)
		{
			char mid = s.charAt(i);
			right.put(mid, right.getOrDefault(mid, 0) - 1);

			for (char c : left)
			{
				if (!seen[c - 'a'][mid - 'a'] && right.getOrDefault(c, 0) > 0)
				{
					seen[c - 'a'][mid - 'a'] = true;
					count++;
				}
			}

			left.add(mid);
		}
		return count;
	}
}
