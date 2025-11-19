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
package challenge.leetcode.medium.countNumberOfMaximumBitwiseORSubsets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2044
 * @Name Count Number of Maximum Bitwise-OR Subsets
 * @Difficulty Medium
 * @Tags array
 * backtracking
 * bit manipulation
 * enumeration
 * weekly contest 263
 * @link <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/">www.leetcode.com/2044</a>
 * @Description Given an integer array <code>nums</code>,
 * find the <b>maximum</b> possible <b>bitwise OR</b> of a subset of <code>nums</code>
 * and return the <b><i>number of different non-empty subsets</b> with the maximum bitwise OR</i>.<br>
 * <br>
 * An array <code>a</code> is a <b>subset</b> of an array <b>b</b>
 * if <b>a</b> can be obtained from <b>b</b> by deleting some (possibly zero) elements of <b>b</b>.
 * Two subsets are considered different if the indices of the elements chosen are different.<br>
 * <br>
 * The bitwise OR of an array <code>a</code> is equal to <code>a[0] OR a[1] OR ... OR a[a.length - 1]</code> <b>(0-indexed)</b>.<br>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [3,1]</code>
 * 			<br><b>Output:</b> {@code 2}
 * 			<br><b>Explanation:</b> The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
 * 			<br>&emsp;- [3]
 * 			<br>&emsp;- [3,1]
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [2,2,2]</code>
 * 			<br><b>Output:</b> {@code 7}
 * 			<br><b>Explanation:</b> All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
 * 			<br>&emsp;- [3]
 * 			<br>&emsp;- [3,1]
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [3,2,1,5]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
 * 			<br>&emsp;- [3,5]
 * 			<br>&emsp;- [3,1,5]
 * 			<br>&emsp;- [3,2,5]
 * 			<br>&emsp;- [3,2,1,5]
 * 			<br>&emsp;- [2,5]
 * 			<br>&emsp;- [2,1,5]
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; nums.length &le; 16</code></li>
 *     <li><code>1 &le; nums[i] &le; 10<sup>5</sup></code></li>
 * </ul>
 * </p>
 **/
// TODO: cleanup
public class CountNumberOfMaximumBitwiseORSubsets
{
	static int subtract(int x, int y)
	{
		while (y != 0)
		{
			int borrow = (~x) & y;
			x = x ^ y;
			y = borrow << 1;
		}
		return x;
	}

	static int sub(int a, int b)
	{
		return a & ~b;
	}

	static int[] subset(int[] ints)
	{
		int max = 0;

		for (int i : ints)
		{
			max |= i;
		}

		int m = max;
		int[] result;
		int start = 0;
		int end = 0;
		for (int i = 0; i < ints.length; i++)
		{
			m = m & ~ints[i];
			if (m == 0)
			{
				end = end == 0 ? i : end;
//				result = Arrays.copyOfRange(ints, 0, i + 1);
//				System.out.println(Arrays.toString(result));
			}
		}

		m = max;
		for (int i = end; i >= 0; i--)
		{
			m = m & ~ints[i];
			if (m == 0)
			{
				start = start == 0 ? i : start;
//				result = Arrays.copyOfRange(ints, start, end + 1);
//				System.out.println(Arrays.toString(result));
			}
		}
		System.out.println("start: " + start + ", int[start]: " + ints[start]);
		System.out.println("end: " + end + ", int[end]: " + ints[end]);

		return null;
	}

	public static int dfs(int[] ints)
	{
		int target = 0;
		for (int i : ints)
		{
			target |= i;
		}

		return dfs(ints, 0, 0, target);
	}

	public static int dfs(int[] ints, int index, int valueOR, int targetOR)
	{
		if (index == ints.length)
		{
			return valueOR == targetOR ? 1 : 0;
		}

		return dfs(ints, index + 1, valueOR, targetOR) +
			dfs(ints, index + 1, valueOR | ints[index], targetOR);
	}

	public int[] findIntersectionValues(int[] nums1, int[] nums2)
	{
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for (int i : nums1)
		{
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}
		for (int i : nums2)
		{
			map2.put(i, map2.getOrDefault(i, 0) + 1);
		}

		int a = 0;
		int b = 0;

		for (Map.Entry<Integer, Integer> entry : map1.entrySet())
		{
			a += map2.getOrDefault(entry.getKey(), 0);
		}
		for (Map.Entry<Integer, Integer> entry : map2.entrySet())
		{
			b += map1.getOrDefault(entry.getKey(), 0);
		}

		return new int[]{a, b};
	}
}
