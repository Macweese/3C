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

package challenge.leetcode.medium.deleteColumnsToMakeSortedII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 08:36 Sun 21 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("955. Delete Columns to Make Sorted II")
class DeleteColumnsToMakeSortedIITest
{
	private static final Map<String[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new String[]{"a","a"},0);
		MAP.put(new String[]{"aaab","aaac"},0);
		MAP.put(new String[]{"epdzz","vjoxh"},0);
		MAP.put(new String[]{"ca","bb","ac"},1);
		MAP.put(new String[]{"xc","yb","za"},0);
		MAP.put(new String[]{"xga","xfb","yfa"},1);
		MAP.put(new String[]{"zyx","wvu","tsr"},3);
		MAP.put(new String[]{"abx","agz","bgc","bfc"},1);
		MAP.put(new String[]{"vdy","vei","zvc","zld"},2);
	}

	@Test
	void minDeletionSize()
	{
		for (Map.Entry<String[], Integer> entry : MAP.entrySet())
		{
			final String[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = DeleteColumnsToMakeSortedII.minDeletionSize(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}