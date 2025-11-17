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
package challenge.leetcode.medium.findTheDuplicateNumber;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 30/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 287
 * @Name Find the Duplicate Number
 * @Difficulty Medium
 * @Tags array
 * two pointer
 * two pointers
 * binary search
 * bit manipulation
 * @link <a href="https://leetcode.com/problems/find-the-duplicate-number/">www.leetcode.com/287</a>
 * @Description Given an array of integers <code>nums</code> containing <code>n + 1</code> integers
 * where each integer is in the range <code>[1, n]</code> inclusive.<br>
 * <br>
 * There is only <b>one repeated number</b> in <code>nums</code>, return <i>this repeated number</i>.<br>
 * <br>
 * You must solve the problem <b>without</b> modifying the array <code>nums</code> and using only constant extra space.<br>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,3,4,2,2]</code>
 * 			<br><b>Output:</b> {@code 2}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [3,1,3,4,2]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>nums = [3,3,3,3,3]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; n &le; 10<sup>5</sup></code></li>
 *     <li><code>nums.length == n + 1</code></li>
 *     <li><code>1 &le; nums[i] &le; n</code></li>
 *     <li>All the integers in <code>nums</code> appear only <b>once</b>
 *     except for <b>precisely one integer</b> which appears <b>two or more times</b>.</li>
 * </ul>
 * </p>
 *
 * <br>
 * <b>Follow up:</b><br>
 * <ul>
 * 		<li>How can we prove that at least one duplicate number must exist in <code>nums</code>?</li>
 * 		<li>Can you solve the problem in linear runtime complexity?</li>
 * </ul>
 **/
public class FindTheDuplicateNumber
{
	public static void main(String[] args)
	{
		int[] CASE_1 = new int[]{1, 3, 4, 2, 2};
		int[] CASE_2 = new int[]{3, 1, 3, 4, 2};
		int[] CASE_3 = new int[]{3, 3, 3, 3, 3};

		System.out.println(findDuplicate(CASE_1));
		System.out.println(findDuplicate(CASE_2));
		System.out.println(findDuplicate(CASE_3));
	}

	// The problem statement and the problem restrictions
	// clouds the conception of a solution
	// If we start by thinking of listing the possible algorithms that fit our problem
	// Finding an element in an array
	// It must be an algorithm to traverse an array
	// It must do so in O(n) time
	// It must not manipulate any elements
	// It must do so in O(1) space, no extra space
	//
	//     ALGORITHM                    TIME          SPACE          MODIFIES DATA
	//     BruteForce                   n^2           constant       No
	//     Sorting                      n*log(n)      log(n)         Yes
	//     Binary Search                n*log(n)      constant       No
	//     Vector/set/hashmap           n             n              No
	//     Negative marking             n             constant       Yes
	//     Mapping Values with indices  n             constant       Yes
	// >>> Tortoise Hare (Fast-Slow)    n             constant       No            <<<
	//
	// The problem becomes trivial to solve now
	public static int findDuplicate(int[] nums)
	{
		int slow = 0;
		int fast = 0;

		System.out.println();
		System.out.println(Arrays.toString(nums));
		do
		{
			System.out.println("Slow " + "[" + slow + "]=" + nums[slow] + "     Fast: [" + fast + "]=" + nums[slow]);
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		while (fast != slow);

		slow = 0;
		while (slow != fast)
		{
			slow = nums[slow];
			fast = nums[fast];
			System.out.println("Slow " + "[" + slow + "]=" + nums[slow] + "     Fast: [" + fast + "]=" + nums[slow]);
		}

		return slow;
	}
}
