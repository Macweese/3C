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
package challenge.leetcode.easy.removeElement;

import java.util.Arrays;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;

/**
 * @author Administrator
 * @Created 23/03/2018,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 27
 * @Difficulty Easy
 * @Tags array,
 * two pointers
 * @link <a href="https://leetcode.com/problems/remove-element/">www.leetcode.com/27</a>
 * @Description Given an integer array <code>nums</code> and an integer <code>val</code>,
 * remove all occurances of <code>val</code> in <code>nums</code> <a href="https://en.wikipedia.org/wiki/In-place_algorithm">in-place</a>.
 * The order of the elements may be changed.<br>
 * Then return <i>the number of elements in</i> <code>nums</code> <i>which are not equal to</i> <code>val</code>.<br>
 * <p>
 * Consider the number of elements of <code>nums</code> which are not equal to <code>val</code> to be <code>k</code>,
 * to get accepted, you need to do the following things:
 * <ul>
 *     <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code>
 *         contain the elements which are not equal to <code>val</code>.<br>
 *         The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li>
 *     <li>Return <code>k</code>.</li>
 * </ul>
 *
 * <b>Custom Judge:</b><br>
 * The judge will test your solution with the following code:<br>
 * <hr>
 * <code>
 * int[] nums = [...]; // Input array<br>
 * int val = ...; // Value to remove<br>
 * // The expected answer with correct length<br>
 * // It is sorted with no values equating val.<br>
 * int[] expectedNums = [...];<br>
 * <br>
 * int k = removeElement(nums, val); // Calls your implementation<br>
 * <br>
 * assert k == expectedNums.length;<br>
 * sort(nums, 0, k); // Sort the first k elements of nums<br>
 * for (int i = 0; i < actualLength; i++)<br>
 * {<br>
 *     assert nums[i] == expectedNums[i];<br>
 * }
 * </code>
 * <hr>
 * If all assertions pass, then your solution will be <b>accepted</b>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [3,2,2,3], val = 3}
 * 			<br><b>Output:</b> {@code 2, nums = [2,2,_,_]}
 * 			<br><b>Explanation:</b> Your function should return {@code k = 2}, with the first two elements of
 *            {@code nums} being {@code 1} and {@code 2} respectively.<br>
 * 			It does not matter what you leave beyond the returned {@code k} (hence they are underscores).
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [0,1,2,2,3,0,4,2], val = 2}
 * 			<br><b>Output:</b> {@code 5, nums = [0,1,4,0,3,_,_,_]}
 * 			<br><b>Explanation:</b> Your function should return {@code k = 5}, with the first five elements of
 *            {@code nums} being {@code 0}, {@code 0}, {@code 1}, {@code 3} and {@code 4} respectively.<br>
 * 			Note that the five elements can be returned in any order.<br>
 * 			It does not matter what you leave beyond the returned {@code k} (hence they are underscores).
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li>{@code 0 <= nums.length <= 100}</li>
 *     <li>{@code 0 <= nums[i] <= 50}</li>
 *     <li>{@code 0 <= val <= 100}</li>
 * </ul>
 * </p>
 **/
public class RemoveElement
{
	static final int[] ARRAY_0 = new int[]{};
	static final int[] ARRAY_1 = new int[]{3, 2, 2, 3};
	static final int[] ARRAY_2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
	static final int[] ARRAY_3 = new int[]{2};

	private static final Logger log = LoggerFactory.getLogger(RemoveElement.class);

	public static void main(String[] args)
	{
		BasicConfigurator.configure();

		log.info("Expected={}, Actual={}", 0, removeElement(ARRAY_0, 0));
		log.info("Expected={}, Actual={}", 2, removeElement(ARRAY_1, 3));
		log.info("Expected={}, Actual={}", 5, removeElement(ARRAY_2, 2));
		log.info("Expected={}, Actual={}", 0, removeElement(ARRAY_3, 3));
	}

	public static int removeElement(int[] ints, int val)
	{
		int i = 0;
		System.out.println("ints = " + Arrays.toString(ints) + ", k=" + i);

		for (int j = 0; j < ints.length; j++)
		{
			System.out.println("ints = " + Arrays.toString(ints) + ", k=" + i);
			if (ints[j] != val)
			{
				int t = ints[i];
				ints[i] = ints[j];
				ints[j] = t;
				i++;
			}
		}
		return i;
	}
}
