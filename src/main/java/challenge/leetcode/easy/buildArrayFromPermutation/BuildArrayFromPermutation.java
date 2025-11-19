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
package challenge.leetcode.easy.buildArrayFromPermutation;

/**
 * @author Administrator
 * @Created 23/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1920
 * @Name Build Array From Permutation
 * @Difficulty Easy
 * @Tags array
 * simulation
 * weekly contest 248
 * @link <a href="https://leetcode.com/problems/build-array-from-permutation/description/">www.leetcode.com/1920</a>
 * @Description Given a <b>zero-based permutation</b> <code>nums</code> (<b>0-indexed</b>),
 * build an array <code>ans</code> of the <b>same length</b> where
 * <code>ans[i] = nums[nums[i]]</code> for each <code>0 <= i < nums.length</code> and return it.<br>
 *
 * <br>A <b>zero-based permutation</b> <code>nums</code> is an array of <b>distinct</b> integers
 * from <code>0</code> to <code>nums.length - 1</code> (<b>inclusive</b>).<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [0,2,1,5,3,4]}
 * 			<br><b>Output:</b> {@code [0,1,2,4,5,3]}
 * 			<br><b>Explanation:</b> The array <code>ans</code> is built as follows:
 * 				<br><code>ans = [
 * 				<br>&#9;nums[nums[0]], nums[nums[1]],
 * 				<br>&#9;nums[nums[2]], nums[nums[3]],
 * 				<br>&#9;nums[nums[4]], nums[nums[5]],
 * 				<br>&emsp;&emsp; &emsp;]
 * 				<br>= [nums[0], nums[2], nums[1],
 * 				<br> &emsp; nums[5], nums[3], nums[4]]
 * 				<br>= [0,1,2,4,5,3]</code>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [5,0,1,2,3,4]}
 * 			<br><b>Output:</b> {@code [4,5,0,1,2,3]}
 * 			<br><b>Explanation:</b> The array <code>ans</code> is built as follows:
 * 				<br><code>ans = [
 * 				<br>&#9;nums[nums[0]], nums[nums[1]],
 * 				<br>&#9;nums[nums[2]], nums[nums[3]],
 * 				<br>&#9;nums[nums[4]], nums[nums[5]],
 * 				<br>&emsp;&emsp; &emsp;]
 * 				<br>= [nums[5], nums[0], nums[1],
 * 				<br> &emsp; nums[2], nums[3], nums[4]]
 * 				<br>= [4,5,0,1,2,3]</code>
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>1 &le; nums.length &le; 1000</code></li>
 *     <li><code>0 &le; nums[i] &lt; nums.length</code></li>
 *     <li>The elements in <code>nums</code> are <b>distinct</b>.</li>
 * </ul>
 * </p>
 *
 * <br><b>Follow-up:</b>
 * <br>Can you solve it without using an extra space (i.e. O(1) memory)?
 **/
public class BuildArrayFromPermutation
{
	public static int[] buildArray(int[] nums)
	{
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			ans[i] = nums[nums[i]];
		}
		return ans;
	}
}
