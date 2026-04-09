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

package challenge.leetcode.easy.robotReturnToOrigin;

/**
 * @author Administrator
 * @Created 06:42 Sun 05 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class RobotReturnToOrigin
{
	public static boolean judgeCircle(String moves)
	{
		int horizontal = 0;
		int vertical = 0;

		for (int i = 0; i < moves.length(); i++)
		{
			if (moves.charAt(i) == 'L')
			{
				horizontal--;
			}
			else if (moves.charAt(i) == 'R')
			{
				horizontal++;
			}
			else if (moves.charAt(i) == 'U')
			{
				vertical--;
			}
			else if (moves.charAt(i) == 'D')
			{
				vertical++;
			}
		}

		return horizontal == 0 && vertical == 0;
	}
}
