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

package challenge.leetcode.medium.minimumNumberOfSecondsToMakeMountainHeightZero;

/**
 * @author Administrator
 * @Created 22:17 Fri 13 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumNumberOfSecondsToMakeMountainHeightZero
{
	public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes)
	{
		long left = 1;
		long right = (long) 1e16;

		while (left < right)
		{
			long mid = left + (right - left) / 2;

			if (canReduceMountain(workerTimes, mountainHeight, mid))
			{
				right = mid;
			}
			else
			{
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean canReduceMountain(int[] workerTimes, int mountainHeight, long timeLimit)
	{
		long totalHeightReduced = 0;

		for (int workerTime : workerTimes)
		{
			long maxHeight = (long) (Math.sqrt(2.0 * timeLimit / workerTime + 0.25) - 0.5);
			totalHeightReduced += maxHeight;

			if (totalHeightReduced >= mountainHeight)
			{
				return true;
			}
		}

		return totalHeightReduced >= mountainHeight;
	}
}
