/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.numberOfPeopleAwareOfSecret;

/**
 * @author Administrator
 * @Created 09/09/2025, 12:49 Tue 09 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2327
 * @Name Number of People Aware of Secret
 * @Difficulty Medium
 * @Tags dp
 * dynamic programming
 * queue
 * simulation
 * weekly contest 300
 * @link <a href="https://leetcode.com/problems/number-of-people-aware-of-a-secret/">www.leetcode.com/2327</a>
 * @Description On day <code>1</code>, one person discovers a secret.<br>
 * <br>
 * You are given an integer <code>delay</code>,
 * which means that each person will <b>share</b> the secret with a new person <b>every day</b>,
 * starting from <code>delay</code> days after discovering the secret.
 * You are also given an integer <code>forget</code>,
 * which means that each person will <b>forget</b> the secret <code>forget</code> days after discovering it.
 * A person <b>cannot</b> share the secret on the same day they forgot it,
 * or on any day afterwards.<br>
 * <br>
 * <p>
 * Given an integer <code>n</code>,
 * return <i>the number of people who know the secret at the end of day</i> <code>n</code>.
 * Since the answer may be very large, return it <b>modulo</b> <code>10<sup>9</sup> + 7</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>n = 6, delay = 2, forget = 4</code>
 * 			<br><b>Output:</b> {@code 5}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;Day 1: Suppose the first person is named A. (1 person)
 * 				<br>&emsp;Day 2: A is the only person who knows the secret. (1 person)
 * 				<br>&emsp;Day 3: A shares the secret with a new person, B. (2 people)
 * 				<br>&emsp;Day 4: A shares the secret with a new person, C. (3 people)
 * 				<br>&emsp;Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
 * 				<br>&emsp;Day 6: B shares the secret with E, and C shares the secret with F. (5 people)
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>n = 4, delay = 1, forget = 3</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;Day 1: The first person is named A. (1 person)
 * 				<br>&emsp;Day 2: A shares the secret with B. (2 people)
 * 				<br>&emsp;Day 3: A and B share the secret with 2 new people, C and D. (4 people)
 * 				<br>&emsp;Day 4: A forgets the secret. B, C, and D share the secret with 3 new people. (6 people)
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>2 &le; n &le; 1000</code></li>
 * 		<li><code>1 &le; delay &lt; forget &le; n</code></li>
 * </ul>
 * </p>
 **/
public class NumberOfPeopleAwareOfSecret
{
	public static long peopleAwareOfSecret(int n, int delay, int forget)
	{
		long[] people = new long[n + 1];

		for (int i = 0; i <= delay; i++)
		{
			people[i] = 1;
		}

		for (int day = delay; day < n + delay - 1; day++)
		{
			if (day >= forget && people[day - forget] >= 0)
			{
				long peopleToForget = people[Math.max(0, day - forget)];
				for (int f = day - forget; f < day; f++)
				{
					people[f] = people[f] - peopleToForget;
				}
			}

			long spread = 0;
			for (int s = day - delay; s < day; s++)
			{
				spread += people[s];
			}
			people[day] = spread;
		}

		return (people[n] - 1) % (1_000_000_000 + 7);
	}
}
