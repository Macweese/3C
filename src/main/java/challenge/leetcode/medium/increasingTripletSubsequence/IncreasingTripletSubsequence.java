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

package challenge.leetcode.medium.increasingTripletSubsequence;

import java.util.Stack;

/**
 * @author Administrator
 * @Created 13:05 Fri 17 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class IncreasingTripletSubsequence
{
	public static boolean increasingTriplets(int[] ints)
	{
		Stack<Integer> stack = new Stack<>();

		// TODO: algorithm isnt 100% correct
		//   weird greedy behavior
		for (int i = 0; i < ints.length; i++)
		{
			if (stack.size() == 3)
			{
				return true;
			}

			if (stack.empty() || ints[i] > stack.peek())
			{
				stack.push(ints[i]);
			}
			else if (!stack.isEmpty() && ints[i] < stack.peek())
			{
				stack.pop();
				stack.push(ints[i]);
			}
			System.out.println(stack);
		}


		return stack.size() >= 3;
	}
}
