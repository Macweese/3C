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

package challenge.leetcode.easy.countElementsWithMaximumFrequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Created 22/09/2025, 02:17 Mon 22 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountElementsWithMaximumFrequency
{
	public static int maxFrequencyElements(int[] nums)
	{
		int maxFreq = 0;
		int freq = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int i : map.values())
		{
			if (i > maxFreq)
			{
				freq = i;
				maxFreq = i;
			}
			else if (i == maxFreq)
			{
				freq = freq + i;
			}
		}

		return freq;
	}
}
