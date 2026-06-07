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

package challenge.leetcode.easy.earliestFinishTimeForLandAndWaterRidesI;

/**
 * @author Administrator
 * @Created 06:11 Tue 02 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class EarliestFinishTimeForLandAndWaterRidesI
{
	public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
	{
		int x = calc(landStartTime, landDuration, waterStartTime, waterDuration);
		int y = calc(waterStartTime, waterDuration, landStartTime, landDuration);
		return Math.min(x, y);
	}

	private static int calc(int[] a1, int[] t1, int[] a2, int[] t2)
	{
		int minEnd = Integer.MAX_VALUE;
		for (int i = 0; i < a1.length; ++i)
		{
			minEnd = Math.min(minEnd, a1[i] + t1[i]);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < a2.length; ++i)
		{
			ans = Math.min(ans, Math.max(minEnd, a2[i]) + t2[i]);
		}
		return ans;
	}
}