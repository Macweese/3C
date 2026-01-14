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

package challenge.leetcode.easy.minimumTimeVisitingAllPoints;

/**
 * @author Administrator
 * @Created 00:09 Tue 13 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumTimeVisitingAllPoints
{
	public static int minTimeToVisitAllPoints(int[][] points)
	{
		int distance = 0;

		for (int i = 0; i < points.length - 1; i++)
		{
			distance += Math.max(Math.abs(points[i + 1][0] - points[i][0]), Math.abs(points[i + 1][1] - points[i][1]));
		}

		return distance;
	}
}
