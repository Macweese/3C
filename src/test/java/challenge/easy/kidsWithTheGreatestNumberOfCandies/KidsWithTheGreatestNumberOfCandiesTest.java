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
 *
 */
package challenge.easy.kidsWithTheGreatestNumberOfCandies;

import com.google.common.primitives.Booleans;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class KidsWithTheGreatestNumberOfCandiesTest
{
	private static final Triple<Integer, int[], List<Boolean>>[] TRIPLES = new Triple[]{
		new ImmutableTriple<>(3, new int[]{2, 3, 5, 1, 3}, List.of(true, true, true, false, true)),
		new ImmutableTriple<>(1, new int[]{4, 2, 1, 1, 2}, List.of(true, false, false, false, false)),
		new ImmutableTriple<>(10, new int[]{12, 1, 12}, List.of(true, false, true))
	};

	@Test
	void kidsWithCandies()
	{
		for (Triple<Integer, int[], List<Boolean>> t : TRIPLES)
		{
			int extra = t.getLeft();
			int[] candies = t.getMiddle();
			boolean[] expected = Booleans.toArray(t.getRight());
			boolean[] actual = Booleans.toArray(KidsWithTheGreatestNumberOfCandies.kidsWithCandies(candies, extra));

			assertArrayEquals(expected, actual);
		}
	}
}