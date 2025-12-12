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

package challenge.leetcode.medium.countMentionsPerUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:18 Fri 12 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3433. Count Mentions Per User")
class CountMentionsPerUserTest
{
	private static final Map<Map.Entry<Integer, List<List<String>>>, int[]> MAP = new HashMap<>();

	static
	{
		MAP.put(Map.entry(2, List.of(List.of("MESSAGE","10","id1 id0"),List.of("OFFLINE","11","0"),List.of("MESSAGE","71","HERE"))),new int[]{2,2});
		MAP.put(Map.entry(2, List.of(List.of("MESSAGE","10","id1 id0"),List.of("OFFLINE","11","0"),List.of("MESSAGE","12","ALL"))),new int[]{2,2});
		MAP.put(Map.entry(2, List.of(List.of("OFFLINE","10","0"),List.of("MESSAGE","12","HERE"))),new int[]{0,1});
		MAP.put(Map.entry(3, List.of(List.of("MESSAGE","5","id0 id1"),List.of("OFFLINE","10","0"),List.of("OFFLINE","15","1"),List.of("MESSAGE","20","ALL"),List.of("OFFLINE","30","2"),List.of("MESSAGE","40","HERE"))),new int[]{2,2,1});
		MAP.put(Map.entry(5, List.of(List.of("MESSAGE","96","id0"),List.of("MESSAGE","98","ALL"),List.of("OFFLINE","22","0"),List.of("MESSAGE","25","id0"),List.of("OFFLINE","40","4"),List.of("OFFLINE","54","1"),List.of("MESSAGE","41","id2 id2 id1 id4 id4"),List.of("OFFLINE","85","0"),List.of("MESSAGE","86","HERE"))),new int[]{3,2,4,2,3});
		MAP.put(Map.entry(3, List.of(List.of("MESSAGE","1","ALL"),List.of("OFFLINE","66","1"),List.of("MESSAGE","66","HERE"),List.of("OFFLINE","5","1"))),new int[]{2,1,2});
		MAP.put(Map.entry(3, List.of(List.of("MESSAGE","2","HERE"),List.of("OFFLINE","2","1"),List.of("OFFLINE","1","0"),List.of("MESSAGE","61","HERE"))),new int[]{1,0,2});
		MAP.put(Map.entry(3, List.of(List.of("MESSAGE","1","id0 id1"),List.of("MESSAGE","5","id2"),List.of("MESSAGE","6","ALL"),List.of("OFFLINE","5","2"))),new int[]{2,2,2});
		MAP.put(Map.entry(2, List.of(List.of("MESSAGE","70","HERE"),List.of("OFFLINE","10","0"),List.of("OFFLINE","71","0"))),new int[]{1,1});
		MAP.put(Map.entry(3, List.of(List.of("MESSAGE","5","HERE"),List.of("OFFLINE","10","0"),List.of("MESSAGE","15","HERE"),List.of("OFFLINE","18","2"),List.of("MESSAGE","20","HERE"))),new int[]{1,3,2});
		MAP.put(Map.entry(5, List.of(List.of("OFFLINE","52","3"),List.of("MESSAGE","49","HERE"),List.of("OFFLINE","36","2"),List.of("OFFLINE","87","0"),List.of("MESSAGE","60","ALL"),List.of("OFFLINE","32","4"),List.of("MESSAGE","22","HERE"),List.of("OFFLINE","94","4"),List.of("MESSAGE","15","ALL"),List.of("OFFLINE","49","1"))),new int[]{4,3,3,4,3});
		MAP.put(Map.entry(7, List.of(List.of("OFFLINE","52","3"),List.of("OFFLINE","49","6"), List.of("MESSAGE","49","HERE"),List.of("OFFLINE","36","2"),List.of("OFFLINE","87","0"),List.of("MESSAGE","60","ALL"),List.of("OFFLINE","32","4"),List.of("MESSAGE","22","HERE"),List.of("OFFLINE","94","4"),List.of("MESSAGE","15","ALL"),List.of("OFFLINE","49","1"), List.of("OFFLINE","49","5"))),new int[]{4,3,3,4,3,3,3});
		MAP.put(Map.entry(2, List.of(List.of("MESSAGE","10","id1 id0"),List.of("OFFLINE","10","0"),List.of("MESSAGE","10","HERE"))),new int[]{1,2});
		MAP.put(Map.entry(2, List.of(List.of("OFFLINE","10","0"),List.of("MESSAGE","10","id1 id0"),List.of("MESSAGE","10","HERE"))),new int[]{1,2});
		MAP.put(Map.entry(20, List.of(List.of("MESSAGE","402","ALL"),List.of("OFFLINE","34","12"),List.of("MESSAGE","103","HERE"),List.of("MESSAGE","327","id4 id1 id2 id3 id9 id7 id14"),List.of("MESSAGE","253","id5 id17 id9 id19 id12 id14 id19 id3"),List.of("OFFLINE","86","13"),List.of("OFFLINE","99","1"),List.of("OFFLINE","123","4"),List.of("OFFLINE","286","9"),List.of("MESSAGE","292","ALL"),List.of("MESSAGE","493","HERE"),List.of("OFFLINE","238","16"),List.of("MESSAGE","34","HERE"),List.of("OFFLINE","496","15"),List.of("OFFLINE","83","2"),List.of("OFFLINE","180","1"),List.of("OFFLINE","244","1"),List.of("OFFLINE","305","13"),List.of("MESSAGE","413","HERE"),List.of("OFFLINE","399","11"),List.of("MESSAGE","41","id6 id7 id16 id19 id5"),List.of("OFFLINE","193","18"),List.of("MESSAGE","414","HERE"),List.of("MESSAGE","251","id19 id1"))),new int[]{7,8,7,9,8,9,8,9,7,9,7,5,7,6,9,7,8,8,7,11});
	}

	@Test
	void countMentions()
	{
		for (Map.Entry<Map.Entry<Integer, List<List<String>>>, int[]> entry : MAP.entrySet())
		{
			final int n = entry.getKey().getKey();
			final List<List<String>> events = entry.getKey().getValue();
			final int[] expected = entry.getValue();
			final int[] actual = CountMentionsPerUser.countMentions(n, new ArrayList<>(events));

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Events", events,
				"Number of users", n,
				"Expected", Arrays.toString(expected),
				"Actual", Arrays.toString(actual),
				""
			);

			assertArrayEquals(expected, actual, message);
		}
	}
}