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

package challenge.leetcode.medium.walkingRobotSimulation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @Created 07:01 Mon 06 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class WalkingRobotSimulation
{
	public static int robotSim(int[] commands, int[][] obstacles)
	{
		int[] dxdy = {0, 1, 0, -1, 0};
		Set<String> obstacleSet = new HashSet<>();

		for (int[] obstacle : obstacles)
		{
			obstacleSet.add(obstacle[0] + "," + obstacle[1]);
		}

		int x = 0, y = 0;
		int dir = 0;
		int maxDistance = 0;

		for (int command : commands)
		{
			if (command == -2)
			{
				dir = (dir + 3) % 4;
			}
			else if (command == -1)
			{
				dir = (dir + 1) % 4;
			}
			else
			{
				for (int i = 0; i < command; i++)
				{
					int dx = x + dxdy[dir];
					int dy = y + dxdy[dir + 1];

					if (obstacleSet.contains(dx + "," + dy))
					{
						break;
					}

					x = dx;
					y = dy;
					maxDistance = Math.max(maxDistance, x * x + y * y);
				}
			}
		}

		return maxDistance;
	}
}
