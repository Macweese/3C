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

package challenge.leetcode.medium.destroyingAsteroids;

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 06:24 Sun 31 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class DestroyingAsteroids
{
	public static boolean asteroidsDestroyed(int mass, int[] asteroids)
	{
		long planet = mass;
		Arrays.sort(asteroids);
		for (int asteroid : asteroids)
		{
			if (planet < asteroid)
			{
				return false;
			}
			planet += asteroid;
		}

		return true;
	}
}
