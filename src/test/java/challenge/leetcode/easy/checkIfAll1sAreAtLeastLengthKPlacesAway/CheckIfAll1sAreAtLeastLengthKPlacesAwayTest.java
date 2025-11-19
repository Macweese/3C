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

package challenge.leetcode.easy.checkIfAll1sAreAtLeastLengthKPlacesAway;

import java.util.Arrays;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 17/11/2025, 01:07 Mon 17 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1437. Check If All 1's Are at Least Length K Places Away")
class CheckIfAll1sAreAtLeastLengthKPlacesAwayTest
{
	private static final Triple<int[], Integer, Boolean>[] TRIPLES = new Triple[]{
		new ImmutableTriple(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2, true),
		new ImmutableTriple(new int[]{1, 0, 0, 1, 0, 1}, 2, false),
	};

	@Test
	void kLengthApartTest()
	{
		for (Triple<int[], Integer, Boolean> triple : TRIPLES)
		{
			final int[] ints = triple.getLeft();
			final int k = triple.getMiddle();
			final boolean expected = triple.getRight();
			final boolean actual = CheckIfAll1sAreAtLeastLengthKPlacesAway.kLengthApart(ints, k);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"ints", Arrays.toString(ints),
				"k", k,
				"Expected", expected,
				"Actual", actual
			);
			assertEquals(expected, actual, message);
		}
	}
}