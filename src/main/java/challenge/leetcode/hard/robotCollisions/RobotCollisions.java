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

package challenge.leetcode.hard.robotCollisions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @Created 06:34 Wed 01 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class RobotCollisions
{
	public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions)
	{
		int n = positions.length;
		Integer[] indices = new Integer[n];

		for (int i = 0; i < n; i++)
		{
			indices[i] = i;
		}

		Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);

		Stack<Integer> stack = new Stack<>();

		for (int i : indices)
		{
			if (directions.charAt(i) == 'R')
			{
				stack.push(i);
			}
			else
			{
				while (!stack.isEmpty() && healths[i] > 0)
				{
					int j = stack.peek();

					if (healths[j] > healths[i])
					{
						healths[j]--;
						healths[i] = 0;
					}
					else if (healths[j] < healths[i])
					{
						healths[i]--;
						healths[j] = 0;
						stack.pop();
					}
					else
					{
						healths[i] = 0;
						healths[j] = 0;
						stack.pop();
					}
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			if (healths[i] > 0)
			{
				result.add(healths[i]);
			}
		}

		return result;
	}
}
