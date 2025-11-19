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

import java.util.Scanner;

public class Main
{
	private static int[] h = new int[100010];
	private static int size;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		for (int i = 1; i <= n; ++i)
		{
			h[i] = sc.nextInt();
		}
		size = n;
		for (int i = n / 2; i > 0; --i)
		{
			down(i);
		}
		while (m-- > 0)
		{
			System.out.print(h[1] + " ");
			h[1] = h[size--];
			down(1);
		}
	}

	public static void down(int u)
	{
		int t = u;
		if (u * 2 <= size && h[u * 2] < h[t])
		{
			t = u * 2;
		}
		if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t])
		{
			t = u * 2 + 1;
		}
		if (t != u)
		{
			swap(t, u);
			down(t);
		}
	}

	public static void up(int u)
	{
		while (u / 2 > 0 && h[u / 2] > h[u])
		{
			swap(u / 2, u);
			u /= 2;
		}
	}

	public static void swap(int i, int j)
	{
		int t = h[i];
		h[i] = h[j];
		h[j] = t;
	}
}