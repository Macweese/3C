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

package challenge.leetcode.medium.partitionArrayAccordingToGivenPivot;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @Created 11:42 Mon 08 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class PartitionArrayAccordingToGivenPivot
{
	public static int[] pivotArray(int[] ints, int pivot)
	{
		Queue<Integer> lessThan = new LinkedList<>();
		Queue<Integer> moreThan = new LinkedList<>();
		int equalCount = 0;

		for (int i : ints)
		{
			if (i < pivot)
			{
				lessThan.add(i);
			}
			else if (i > pivot)
			{
				moreThan.add(i);
			}
			else
			{
				equalCount++;
			}
		}

		int index = 0;
		while (!lessThan.isEmpty())
		{
			ints[index++] = lessThan.remove();
		}
		while (equalCount > 0)
		{
			ints[index++] = pivot;
			equalCount--;
		}
		while (!moreThan.isEmpty())
		{
			ints[index++] = moreThan.remove();
		}

		return ints;
	}
}
