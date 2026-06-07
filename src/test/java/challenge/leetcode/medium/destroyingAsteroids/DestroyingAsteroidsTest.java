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
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:25 Sun 31 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2126. Destroying Asteroids")
class DestroyingAsteroidsTest
{
	private static final Map<Input, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(10,new int[]{3,9,19,5,21}),true);
		MAP.put(new Input(5,new int[]{4,9,23,4}),false);
		MAP.put(new Input(70,new int[]{100,80,100,20}),true);
//		MAP.put(new Input(,new int[]),);
	}

	@Test
	void asteroidsDestroyed()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final int mass = entry.getKey().mass();
			final int[] asteroids = entry.getKey().asteroids();
			final Boolean expected = entry.getValue();
			final Boolean actual = DestroyingAsteroids.asteroidsDestroyed(mass, asteroids);

			String message = String.format("Test failed for case:"
					+ "%n%10s "
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s "
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Mass", mass,
				"Asteroids", Arrays.toString(asteroids),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int mass, int[] asteroids)
{

}