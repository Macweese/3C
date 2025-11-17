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
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 * @link <a href="">www.leetcode.com/999999999999999999999</a>
 * @Description Description
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <a href=""/>1000. NAME (Leetcode)</a><br>
 * <br>
 * {@link solution. 10000. NAME (local)}<br>
 **/
public class CountElementsWithMaximumFrequency
{
	static void main(String[] args)
	{
		int[] CASE_1 = new int[]{1,2,2,3,1,4};
		int[] CASE_2 = new int[]{1,2,3,4,5};
		int[] CASE_3 = new int[]{10,12,11,9,6,19,11};

		System.out.println(maxFrequencyElements(CASE_1));
		System.out.println(maxFrequencyElements(CASE_2));
		System.out.println(maxFrequencyElements(CASE_3));
	}

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
