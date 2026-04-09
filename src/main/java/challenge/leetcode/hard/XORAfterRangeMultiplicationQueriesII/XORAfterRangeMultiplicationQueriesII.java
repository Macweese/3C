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

package challenge.leetcode.hard.XORAfterRangeMultiplicationQueriesII;

/**
 * @author Administrator
 * @Created 06:33 Thu 09 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class XORAfterRangeMultiplicationQueriesII
{
	private static final int MOD = 1_000_000_007;

	public static int xorAfterQueries(int[] ints, int[][] queries)
	{
		for (int[] query : queries)
		{
			int l = query[0];
			int r = query[1];
			int k = query[2];
			int v = query[3];

			int idx = l;
			while (idx <= r)
			{
				ints[idx] = (int) (((long) ints[idx] * v) % MOD);
				idx += k;
			}
		}

		int n = ints.length;
		int result = ints[0];

		for (int i = 1; i < n; ++i)
		{
			result ^= ints[i];
		}

		return result;
	}
}
