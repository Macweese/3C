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

package challenge.leetcode.easy.restoreFinishingOrder;

/**
 * @author Administrator
 * @Created 12/09/2025, 18:47 Fri 12 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3668
 * @Name Restore Finishing Order
 * @Difficulty Easy
 * @Tags weekly contest 465
 * @link <a href="https://leetcode.com/problems/restore-finishing-order/">www.leetcode.com/3668</a>
 * @Description You are given an integer array <code>order</code> of length <code>n</code> and an integer array <code>friends</code>.
 * <ul>
 * 		<li><code>order</code> contains every integer from <code>1</code> to <code>n</code> <b>exactly once</b>,
 * 			representing the IDs of the participants of a race in their <b>finishing</b> order.</li>
 * 		<li><code>friends</code> contains the IDs of your friends in the race <b>sorted</b> in strictly increasing order.
 * 			Each ID in friends is guaranteed to appear in the <code>order</code> array.</li>
 * </ul>
 * <p>
 * Return an array containing your friends' IDs in their <b>finishing</b> order.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>order = [3,1,2,5,4], friends = [1,3,4]</code>
 * 			<br><b>Output:</b> {@code [3,1,4]}
 * 			<br><b>Explanation:</b> The finishing order is <code>[<u><b>3</b></u>, <u><b>1</b></u>, 2, 5, <u><b>4</b></u>]</code>.
 * 				Therefore, the finishing order of your friends is <code>[3, 1, 4]</code>.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>order = [1,4,5,3,2], friends = [2,5]</code>
 * 			<br><b>Output:</b> {@code [5,2]}
 * 			<br><b>Explanation:</b> The finishing order is [1, 4, <u><b>5</b></u>, 3, <u><b>2</b></u>].
 * 				Therefore, the finishing order of your friends is <code>[5, 2]</code>.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; n == order.length &le; 100</code></li>
 * 		<li><code>order</code> contains every integer from <code>1</code> to <code>n</code> exactly once</li>
 * 		<li><code>1 &le; friends.length &le; min(8, n)</code></li>
 * 		<li><code>1 &le; friends[i] &le; n</code></li>
 * 		<li><code>friends</code> is strictly increasing</li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class RestoreFinishingOrder
{
	public static int[] recoverOrder(int[] order, int[] friends)
	{
		int index = 0;
		int[] sorted = new int[friends.length];

		for (int i : order)
		{
			int j = binarySearch(friends, i);
			if (j != -1 && i == friends[j])
			{
				sorted[index++] = i;
			}
		}
		return sorted;
	}

	public static int binarySearch(int[] ints, int value)
	{
		int l = 0;
		int r = ints.length - 1;

		while (l <= r)
		{
			int m = l + (r - l) / 2;

			if (ints[m] == value)
			{
				return m;
			}

			if (ints[m] < value)
			{
				l = m + 1;
			}
			else
			{
				r = m - 1;
			}
		}

		return -1;
	}
}
