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
package challenge.easy.searchInsertPosition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SearchInsertPositionTest
{
	static final int[] NUMS_1 = new int[]{1, 3, 5, 6};
	static final int[] NUMS_2 = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	static final int[] NUMS_3 = new int[]{1};
	static final int[] NUMS_4 = new int[]{1, 3};
	static final int[] NUMS_5 = new int[]{1, 2, 4, 6, 7};

	@Test
	void binarySearch()
	{
		assertEquals(1, SearchInsertPosition.binarySearch(NUMS_1, 2));
		assertEquals(2, SearchInsertPosition.binarySearch(NUMS_1, 5));
		assertEquals(4, SearchInsertPosition.binarySearch(NUMS_1, 7));
		assertEquals(4, SearchInsertPosition.binarySearch(NUMS_2, 5));
		assertEquals(0, SearchInsertPosition.binarySearch(NUMS_3, 1));
		assertEquals(1, SearchInsertPosition.binarySearch(NUMS_4, 2));
		assertEquals(2, SearchInsertPosition.binarySearch(NUMS_5, 3));
	}
}