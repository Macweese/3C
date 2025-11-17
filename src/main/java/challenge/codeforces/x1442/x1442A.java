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

package challenge.codeforces.x1442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.max;
import java.util.StringTokenizer;

/**
 * @author Administrator
 * @Created 14/11/2025, 11:49 Fri 14 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class x1442A
{
	static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(tokenizer.nextToken());
		StringBuilder sb = new StringBuilder();

		while (T-->0)
		{
			tokenizer = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int[] sums = readArr(n, in, tokenizer);
			int[] ints = new int[n];
			ints[0] = sums[0];

			for (int i = 1; i < n; ++i)
			{
				ints[i] = sums[i] - sums[i-1];
			}

			long sum = 0L;
			for (int i = 1; i < n; ++i)
			{
				sum += max(0, -1 * ints[i]);
			}

			sb.append(sum <= ints[0] ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
	public static int[] readArr(int n, BufferedReader in, StringTokenizer tokenizer) throws IOException
	{
		int[] ints = new int[n];
		tokenizer = new StringTokenizer(in.readLine());

		for (int i = 0; i < n; ++i)
		{
			ints[i] = Integer.parseInt(tokenizer.nextToken());
		}

		return ints;
	}
}
