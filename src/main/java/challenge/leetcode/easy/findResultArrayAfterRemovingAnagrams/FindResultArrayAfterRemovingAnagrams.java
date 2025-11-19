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

package challenge.leetcode.easy.findResultArrayAfterRemovingAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @Created 13/10/2025, 23:27 Mon 13 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class FindResultArrayAfterRemovingAnagrams
{
	public static List<String> removeAnagrams(String[] words)
	{
		List<String> result = new ArrayList<>();
		HashMap<Character, Integer> currCharMap = new HashMap<>();
		String word = words[0];

		for (char c : words[0].toCharArray())
		{
			currCharMap.put(c, currCharMap.getOrDefault(c, 0) + 1);
		}

		for (int i = 1; i < words.length; i++)
		{
			String next = words[i];
			HashMap<Character, Integer> nextCharMap = new HashMap<>();

			for (char c : next.toCharArray())
			{
				nextCharMap.put(c, nextCharMap.getOrDefault(c, 0) + 1);
			}

			if (nextCharMap.equals(currCharMap))
			{
				continue;
			}

			currCharMap = nextCharMap;
			result.add(word);
			word = words[i];
		}

		result.add(word);
		return result;
	}
}
