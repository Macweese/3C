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

package challenge.leetcode.easy.largestTriangleArea;

import java.awt.Point;

/**
 * @author Administrator
 * @Created 27/09/2025, 14:11 Sat 27 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class LargestTriangleArea
{
	public static double largestTriangleArea(int[][] points)
	{
		double maxArea = 0;

		for (int i = 0; i < points.length; i++)
		{
			for (int j = i + 1; j < points.length; j++)
			{
				for (int k = j + 1; k < points.length; k++)
				{
					double a = Point.distance(points[i][0], points[i][1], points[j][0], points[j][1]);
					double b = Point.distance(points[j][0], points[j][1], points[k][0], points[k][1]);
					double c = Point.distance(points[k][0], points[k][1], points[i][0], points[i][1]);

					double s = (a + b + c) / 2;
					double area = Math.sqrt(Math.abs(s * (s - a) * (s - b) * (s - c)));
					maxArea = Math.max(area, maxArea);
				}
			}
		}

		return maxArea;
	}
}
