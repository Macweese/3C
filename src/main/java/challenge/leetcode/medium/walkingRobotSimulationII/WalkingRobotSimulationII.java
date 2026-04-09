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

package challenge.leetcode.medium.walkingRobotSimulationII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 05:59 Tue 07 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class WalkingRobotSimulationII
{
	public static Object[] runSimulation(String[] args, int[][] vals)
	{
		int valIndex = 0;
		Robot robot = null;
		List<Object> result = new ArrayList<>();

		for (String arg : args)
		{
			if (arg.equalsIgnoreCase("Robot"))
			{
				robot = new Robot(vals[valIndex][0], vals[valIndex][0]);
				result.add(null);
			}
			else if (robot != null && arg.equalsIgnoreCase("step"))
			{
				robot.step(vals[valIndex][0]);
				result.add(null);
			}
			else if (robot != null && arg.equalsIgnoreCase("getPos"))
			{
				result.add(robot.getPos());
			}
			else if (robot != null && arg.equalsIgnoreCase("getDir"))
			{
				result.add(robot.getDir());
			}
			valIndex++;
		}

		return result.toArray();
	}
}

class Robot
{
	private final int width;
	private final int height;
	private int index;
	private boolean moved;

	public Robot(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.index = 0;
		this.moved = false;
	}

	public void step(int num)
	{
		moved = true;
		int perimeter = 2 * (width + height - 2);
		index = (index + num) % perimeter;
	}

	public int[] getPos()
	{
		if (!moved)
		{
			return new int[]{0, 0};
		}

		int perimeter = 2 * (width + height - 2);
		int pos = index % perimeter;

		if (pos < width)
		{
			return new int[]{pos, 0};
		}
		pos -= width;

		if (pos < height - 1)
		{
			return new int[]{width - 1, pos + 1};
		}
		pos -= (height - 1);

		if (pos < width - 1)
		{
			return new int[]{width - 1 - pos - 1, height - 1};
		}
		pos -= (width - 1);

		return new int[]{0, height - 1 - pos - 1};
	}

	public String getDir()
	{
		if (!moved)
		{
			return "East";
		}

		int perimeter = 2 * (width + height - 2);
		int pos = index % perimeter;

		if (pos == 0)
		{
			return "South";
		}

		if (pos < width)
		{
			return "East";
		}
		pos -= width;

		if (pos < height - 1)
		{
			return "North";
		}
		pos -= (height - 1);

		if (pos < width - 1)
		{
			return "West";
		}

		return "South";
	}
}