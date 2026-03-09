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

package challenge.leetcode.medium.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @Created 05:38 Mon 09 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class GroupAnagrams
{
	public static List<List<String>> groupAnagrams(String[] strings)
	{
		List<List<String>> result = new ArrayList<>();

		for (int i = 0; i < strings.length; ++i)
		{
			if (strings[i] == null)
			{
				continue;
			}

			List<String> wordGroup = new ArrayList<>();
			wordGroup.add(strings[i]);
			Map<Character, Integer> charMap = new HashMap<>();

			for (char c : strings[i].toCharArray())
			{
				charMap.put(c, charMap.getOrDefault(c, 0) + 1);
			}

			for (int j = i + 1; j < strings.length; ++j)
			{
				if (strings[j] == null)
				{
					continue;
				}

				Map<Character, Integer> candidateMap = new HashMap<>();
				for (char c : strings[j].toCharArray())
				{
					candidateMap.put(c, candidateMap.getOrDefault(c, 0) + 1);
				}
				if (charMap.equals(candidateMap))
				{
					wordGroup.add(strings[j]);
					strings[j] = null;
				}
			}

			result.add(wordGroup);
		}

		return result;
	}
}
