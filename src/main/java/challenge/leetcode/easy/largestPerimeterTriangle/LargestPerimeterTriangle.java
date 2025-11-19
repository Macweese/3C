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

package challenge.leetcode.easy.largestPerimeterTriangle;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 28/09/2025, 07:40 Sun 28 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class LargestPerimeterTriangle
{
	public static int largestPerimeter(int[] sides)
	{
		Arrays.sort(sides);
		int a;
		int b;
		int c = sides[sides.length - 3];
		int perimeter = 0;

		for (int i = sides.length - 1; i >= 0; i--)
		{
			for (int j = i - 1; j >= 0; j--)
			{
				if (sides[i] + sides[j] + c < perimeter)
				{
					break;
				}
				for (int k = j - 1; k >= 0; k--)
				{
					a = sides[i];
					b = sides[j];
					c = sides[k];

					if (a + b <= c || a + c <= b || b + c <= a)
					{
						continue;
					}
					perimeter = Math.max(perimeter, a + b + c);
					break;
				}
			}
		}

		return perimeter;
	}

	private static boolean isValidTriagle(int a, int b, int c)
	{
		return a + b > c && a + c > b && b + c > a;
	}
}
