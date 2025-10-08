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
package challenge.medium.smallestSubarraysWithMaximumBitwiseOR;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author Administrator
 * @Created 29/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2411
 * @Name Smallest Subarray With Maximum Bitwise-OR
 * @Difficulty Medium
 * @Tags array
 * binary search
 * bit manipulation
 * sliding window
 * biweekly contest 87
 * @link <a href="https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/">www.leetcode.com/2411</a>
 * @Description You are given a <b>0-indexed</b> array <code>nums</code> of length <code>n</code>,
 * consisting of non-negative integers. For each index <code>i</code> from <code>0</code> to <code>n - 1</code>,
 * you must determine the size of the <b>minimum sized</b> non-empty subarray of <code>nums</code>
 * starting at <code>i</code> <b>(inclusive)</b> that has the <b>maximum</b> possible <b>bitwise OR</b>.
 *
 * <ul>
 * 		<li>In other words, let <code>B<sub>ij</sub></code> be the bitwise OR of the subarray <code>nums[i...j]</code>.
 * 		You need to find the smallest subarray starting at <code>i</code>,
 * 		such that bitwise OR of this subarray is equal to <code>max(B<sub>ik</sub>)</code> where <code>i <= k <= n - 1</code>.</li>
 * </ul>
 * <p>
 * The bitwise OR of an array is the bitwise OR of all the numbers in it.<br>
 * <br>
 * Return an <i>integer array</i> <code>answer</code> <i>of size n where</i> <code>answer[i]</code>
 * <i>is the length of the <b>minimum</b> sized subarray starting at</i> <i>i with <b>maximum</b> bitwise OR</i>.<br>
 * <br>
 * A <b>subarray</b> is a contiguous non-empty sequence of elements within an array.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,0,2,1,3]</code>
 * 			<br><b>Output:</b> {@code [3,3,2,2,1]}
 * 			<br><b>Explanation:</b> The maximum possible bitwise OR starting at any index is 3.
 * 			<br>&emsp;- Starting at index 0, the shortest subarray that yields it is [1,0,2].
 * 			<br>&emsp;- Starting at index 1, the shortest subarray that yields the maximum bitwise OR is [0,2,1].
 * 			<br>&emsp;- Starting at index 2, the shortest subarray that yields the maximum bitwise OR is [2,1].
 * 			<br>&emsp;- Starting at index 3, the shortest subarray that yields the maximum bitwise OR is [1,3].
 * 			<br>&emsp;- Starting at index 4, the shortest subarray that yields the maximum bitwise OR is [3].
 * 			<br>&emsp;Therefore, we return [3,3,2,2,1].
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [1,2]</code>
 * 			<br><b>Output:</b> {@code [2,1]}
 * 			<br><b>Explanation:</b>
 * 			<br>&emsp;Starting at index 0, the shortest subarray that yields the maximum bitwise OR is of length 2.
 * 			<br>&emsp;Starting at index 1, the shortest subarray that yields the maximum bitwise OR is of length 1.
 * 			<br>&emsp;Therefore, we return [2,1].
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>n == nums.length</code></li>
 *     <li><code>1 &le; n &le; 10<sup>5</sup></code></li>
 *     <li><code>0 &le; nums[i] &le; 10<sup>5</sup></code></li>
 * </ul>
 * </p>
 **/
public class SmallestSubarraysWithMaximumBitwiseOR
{
	public static void main(String[] args)
	{

	}

	/*
	 *
	 *
	 */

	public static int[] smallestSubarrays(int[] nums)
	{


		List<List<Integer>> result = new ArrayList<>();


		List<Integer> nodes = Arrays.stream(nums).boxed().toList();
		result = bfs(nodes, result, new ArrayList<>());

		test(nums, 0);
		return nums;
	}


	public static List<List<Integer>> bfs(List<Integer> nodes, List<List<Integer>> result, List<Integer> current)
	{
		if (nodes.isEmpty())
		{
			return result;
		}

		Queue<Integer> queue = new ArrayDeque<>(current);
		List<Integer> currentLevel = new ArrayList<>();

		for (int i = 0; i < current.size(); i++)
		{
//			currentLevel.add();
		}

		result.add(currentLevel);
		return result;
	}

	public static void test(int[] ints, int depth)
	{
		List<Integer> result = new ArrayList<>();

		int size = (int) Math.max(ints.length - Math.pow(2, depth + 1), Math.pow(2, depth - 1));


	}
}


/*
 *
 * depth
 * root = 0               1                2^0 nodes
 *                  _____/ \____
 * 1               2            3          2^1 nodes
 *                / \          / \
 * 2            4     5      6     7       2^2 nodes
 *             / \   / \    / \   / \
 * 3          8   9 10 11  12 13 14 15     2^3 nodes
 *           / \
 * 4        16 17                          2^4 nodes
 *
 *
 *
 *
 *
 */
class TreeNode
{
	private int value = 0;
	private TreeNode leftNode = null;
	private TreeNode rightNode = null;

	TreeNode()
	{
	}

	TreeNode(int value)
	{
		this.value = value;
	}

	public void addLeft()
	{
		this.leftNode = new TreeNode();
	}

	public void addRight()
	{
		this.rightNode = new TreeNode();
	}

	public void addRight(int value)
	{
		this.rightNode = new TreeNode(value);
	}

	public void addLeft(int value)
	{
		this.leftNode = new TreeNode(value);
	}

	public void removeLeft()
	{
		this.leftNode = null;
	}

	public void removeRight()
	{
		this.rightNode = null;
	}

	public boolean hasLeft()
	{
		return this.leftNode != null;
	}

	public boolean hasRight()
	{
		return this.rightNode != null;
	}

	public boolean hasChildren()
	{
		return hasLeft() || hasRight();
	}

	public TreeNode getLeftNode()
	{
		return leftNode;
	}

	public TreeNode getRightNode()
	{
		return rightNode;
	}

	public TreeNode createTree(int size)
	{
		TreeNode root = new TreeNode(1);
		TreeNode node = root;

		int value = 1;
		int d = (int) (Math.log(size) / Math.log(2));
		int index = (int) Math.pow(2, d);
		TreeNode[] nodes = new TreeNode[size];
		for (int i = 0; i < size; i++)
		{
			nodes[i] = new TreeNode();
			value++;
		}

		return node;
	}

	TreeNode createTree(TreeNode parent, int depth, int value)
	{


		return null;
	}
}
