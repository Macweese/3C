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
package challenge.leetcode.hard.blockPlacementQueries;

import challenge.leetcode.medium.fruitsIntoBasketsIII.FruitsIntoBasketsIII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Administrator
 * @Created 06/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3161. Block Placement Queries
 * @Difficulty Hard
 * @Tags array
 * binary search
 * binary indexed tree
 * segment tree
 * biweekly contest 131
 * @link <a href="https://leetcode.com/problems/block-placement-queries/">www.leetcode.com/3161</a>
 * @Description There exists an infinite number line, with its origin at 0 and extending towards the <strong>positive</strong> x-axis.<br>
 * <br>
 * You are given a 2D array <code>queries</code>, which contains two types of queries:
 *
 * <ol>
 * 		<li>For a query of types 1, <code>queries[i] = [1, x]</code>.
 * 			Build an obstacle at distance <code>x</code> from the origin.
 * 			It is guaranteed that there is <strong>no</strong> obstacle at distance <code>x</code> when the query is asked.</li>
 * 		<li>For a query of types 2, <code>queries[i] = [2, x, sz]</code>.
 * 			Check if it is possible to place a block of size <code>sz</code> <em>anywhere</em> in the range <code>[0, x]</code> on the line,
 * 			such that the block <strong>entirely</strong> lies in the range <code>[0, x]</code>.
 * 			A block <strong>cannot </strong>be placed if it intersects with any obstacle, but it may touch it.
 * 			Note that you do<strong> not</strong> actually place the block. Queries are separate.</li>
 * </ol>
 * <br>
 * <p>
 * Return a boolean array <code>results</code>,
 * where <code>results[i]</code> is <code>true</code> if you can place the block specified in the <code>i<sup>th</sup></code> query of types 2,
 * and <code>false</code> otherwise.
 *
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]</code>
 * 			<br><b>Output:</b> {@code [false,true,true]}
 * 			<br><b>Explanation:</b>
 * 				<img alt="" src="https://assets.leetcode.com/uploads/2024/04/22/example0block.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 309px; height: 129px;">
 * 				<br>&emsp;For query 0, place an obstacle at <code>x = 2</code>.
 * 					A block of size at most 2 can be placed before <code>x = 3</code>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>queries = [[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]</code>
 * 			<br><b>Output:</b> {@code [true,true,false]}
 * 			<br><b>Explanation:</b>
 * 				<img alt="" src="https://assets.leetcode.com/uploads/2024/04/22/example1block.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 310px; height: 130px;">
 * 				<br>&emsp;Place an obstacle at <code>x = 7</code> for query 0.
 * 					A block of size at most 7 can be placed before <code>x = 7</code>
 * 				<br>&emsp;Place an obstacle at <code>x = 2</code> for query 2.
 * 					Now, a block of size at most 5 can be placed before <code>x = 7</code>,
 * 					and a block of size at most 2 before <code>x = 2</code>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; queries.length &le; 15 &times; 10<sup>4</sup> </code></li>
 * 		<li><code>2 &le; queries[i] &le; 3</code></li>
 * 		<li><code>1 &le; queries[i][0] &le; 2</code></li>
 * 		<li><code>1 &le; x, sz &le; min(5, 10<sup>4</sup>, 3, &times; queries.length)</code></li>
 * </ul>
 * </p>
 * <br>
 * @Similar <a href="https://leetcode.com/problems/fruits-into-baskets-iii/"/>3479. Fruits Into Baskets III (Leetcode)</a><br>
 * {@link FruitsIntoBasketsIII 3479. Fruits Into Baskets III (local)}<br>
 * <a href="https://leetcode.com/problems/fruits-into-baskets-iii/"/>1739. Building Boxes (Leetcode)</a><br>
 * {@link BuildingBoxes 1739. Building Boxes (local)}<br>
 */
public class BlockPlacementQueries
{
	public static List<Boolean> getResults(int[][] queries)
	{
		final int n = Math.min(50000, queries.length * 3);
		List<Boolean> ans = new ArrayList<>();
		FenwickTree tree = new FenwickTree(n + 1);
		TreeSet<Integer> obstacles = new TreeSet<>(Arrays.asList(0, n));

		for (int[] query : queries)
		{
			final int type = query[0];
			if (type == 1)
			{
				final int x = query[1];
				obstacles.add(x);
			}
		}

		Iterator<Integer> it = obstacles.iterator();
		int x1 = it.next();
		while (it.hasNext())
		{
			final int x2 = it.next();
			tree.add(x2, x2 - x1);
			x1 = x2;
		}

		for (int i = queries.length - 1; i >= 0; --i)
		{
			final int type = queries[i][0];
			final int x = queries[i][1];
			if (type == 1)
			{
				final Integer next = obstacles.higher(x);
				final Integer prev = obstacles.lower(x);
				if (next != null && prev != null)
				{
					tree.add(next, next - prev);
				}
				obstacles.remove(x);
			}
			else
			{
				final int sz = queries[i][2];
				final int prev = obstacles.floor(x);
				ans.add(tree.get(prev) >= sz || x - prev >= sz);
			}
		}

		Collections.reverse(ans);
		return ans;
	}
}

class FenwickTree
{
	private int[] vals;

	public FenwickTree(int n)
	{
		vals = new int[n + 1];
	}

	private static int lowbit(int i)
	{
		return i & -i;
	}

	public void add(int i, int val)
	{
		while (i < vals.length)
		{
			vals[i] = Math.max(vals[i], val);
			i += lowbit(i);
		}
	}

	public int get(int i)
	{
		int res = 0;
		while (i > 0)
		{
			res = Math.max(res, vals[i]);
			i -= lowbit(i);
		}
		return res;
	}
}