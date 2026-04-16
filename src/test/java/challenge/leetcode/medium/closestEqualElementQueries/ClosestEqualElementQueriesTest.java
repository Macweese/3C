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

package challenge.leetcode.medium.closestEqualElementQueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import utils.DataUtils;
import utils.IntArraySpec;

/**
 * @author Administrator
 * @Created 06:07 Thu 16 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3488. Closest Equal Element Queries")
class ClosestEqualElementQueriesTest
{
	private static final Map<Input, List<Integer>> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{1,3,1,4,1,3,2},new int[]{0,3,5}), Arrays.asList(2,-1,3));
		MAP.put(new Input(new int[]{1,2,3,4},new int[]{0,1,2,3}), Arrays.asList(-1,-1,-1,-1));
		MAP.put(new Input(new int[]{5,15},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{17,5},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{13,5,5},new int[]{1}), List.of(1));
		MAP.put(new Input(new int[]{23,17},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{8,14,5},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{10,24,2,4},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{14,2,19,3,9},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{23,6,10},new int[]{2,2}),Arrays.asList(-1,-1));
		MAP.put(new Input(new int[]{23,24,1,5,21},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{13,18,17,22,10},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{23,24,18,25,24},new int[]{2}), List.of(-1));
		MAP.put(new Input(new int[]{18,6,8,15},new int[]{2,1}),Arrays.asList(-1,-1));
		MAP.put(new Input(new int[]{14,9,10,2,4,15,2},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{4,1,23,18,1,21,9,7},new int[]{1}), List.of(3));
		MAP.put(new Input(new int[]{4,22,13,20,13,2,18},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{24,6,19,21,22,23},new int[]{2,0}),Arrays.asList(-1,-1));
		MAP.put(new Input(new int[]{19,2,11,12,19,22,5},new int[]{5,4}),Arrays.asList(-1,3));
		MAP.put(new Input(new int[]{1,11,12,10,4,8,19,24,9},new int[]{2}), List.of(-1));
		MAP.put(new Input(new int[]{8,4,16,7,22,4,23,21,13,24},new int[]{1}), List.of(4));
		MAP.put(new Input(new int[]{23,7,16,8,6,7,3,11,12,19},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{6,20,25,24,23,15,5,13},new int[]{1,1}),Arrays.asList(-1,-1));
		MAP.put(new Input(new int[]{5,3,24,9,11,19,23,8,11,2,18},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{9,10,11,16,7,13,10},new int[]{0,2,3}),Arrays.asList(-1,-1,-1));
		MAP.put(new Input(new int[]{22,1,20,1,14,22,8,18,23,2},new int[]{1,1}),Arrays.asList(2,2));
		MAP.put(new Input(new int[]{25,2,22,8,24,17,11,1,22,19,25},new int[]{0,0}),Arrays.asList(1,1));
		MAP.put(new Input(new int[]{9,19,4,1,5,1,20,7,4,6,10,13,9},new int[]{8,1}),Arrays.asList(6,-1));
		MAP.put(new Input(new int[]{22,18,17,22,4,12,18,9,20,13,17},new int[]{2,1}),Arrays.asList(3,5));
		MAP.put(new Input(new int[]{12,6,22,5,2,21,11,19,22,20,13,14,2},new int[]{1,0}),Arrays.asList(-1,-1));
		MAP.put(new Input(new int[]{25,25,13,23,10,16,16,7,20,5,12,17,12},new int[]{5,0}),Arrays.asList(1,1));
		MAP.put(new Input(new int[]{20,16,19,8,19,21,23,22,18,3,2,22},new int[]{0,2,4}),Arrays.asList(-1,2,2));
		MAP.put(new Input(new int[]{2,18,24,14,18,15,16,19,17,17,7,18,13},new int[]{3,2}),Arrays.asList(-1,-1));
		MAP.put(new Input(new int[]{6,7,5,1,25,7,24,22,21,5,2,12,17,13},new int[]{1,2,1}),Arrays.asList(4,7,4));
		MAP.put(new Input(new int[]{21,16,11,3,3,2,10,5,1,5,17,14,16,19,12,20},new int[]{0}), List.of(-1));
		MAP.put(new Input(new int[]{8,4,11,12,8,1,17,17,24,21,16,16,12,22,5,3,18},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{13,15,22,18,9,19,5,12,5,20,7,12,16,15,24},new int[]{4,1}),Arrays.asList(-1,3));
		MAP.put(new Input(new int[]{1,6,16,19,10,3,10,3,14,23,14,21,8,24,25,7,21,11},new int[]{1}), List.of(-1));
		MAP.put(new Input(new int[]{6,17,22,5,25,21,15,13,3},new int[]{0,7,0,5,3,7}),Arrays.asList(-1,-1,-1,-1,-1,-1));
		MAP.put(new Input(new int[]{23,11,18,9,20,9,4,3,12,25,24,18,23,17,24,13},new int[]{4,0,2}),Arrays.asList(-1,4,7));
		MAP.put(new Input(new int[]{20,5,23,25,4,14,10,21,2,22,14,22,21,9,8,12,7},new int[]{0,1,0}),Arrays.asList(-1,-1,-1));
		MAP.put(new Input(new int[]{9,6,19,20,11,1,1,18,20,14,7,19,18,1,25,9,1,20,7},new int[]{2,2,4}),Arrays.asList(9,9,-1));
		MAP.put(new Input(new int[]{23,25,8,20,24,7,10,16,7,22,21,5},new int[]{3,6,3,6,5,3}),Arrays.asList(-1,-1,-1,-1,3,-1));
		MAP.put(new Input(new int[]{15,4,11,13,14,17,3,3,20,4,24,19,7,21,15,24,2},new int[]{2,4,8,9}),Arrays.asList(-1,-1,-1,8));
		MAP.put(new Input(new int[]{3,25,2,7,7,9,3,3,8,19,16,16,15,16,10,14,8,11},new int[]{2,3,1,3,0}),Arrays.asList(-1,1,-1,1,6));
		MAP.put(new Input(new int[]{5,8,9,11,8,8,22,22,12,13,2,14,22,25,3,8},new int[]{2,5,1,5,8,2,2}),Arrays.asList(-1,1,2,1,-1,-1,-1));
		MAP.put(new Input(new int[]{10,6,22,15,3,16,10,21,24,10,14,16,1,23,14,14},new int[]{2,6,3,2,4,5}),Arrays.asList(-1,3,-1,-1,-1,6));
		MAP.put(new Input(new int[]{21,13,20,18,20,4,22,2,17,17,4,12,18,15,12,9,9,8,13},new int[]{3,6,2,5,3,0}),Arrays.asList(9,-1,2,5,9,-1));
		MAP.put(new Input(new int[]{6,13,15,11,2,5,4,11,5,12,3,17,6,2,18,16,1,4,12},new int[]{6,3,5,4,2,2,3}),Arrays.asList(8,4,3,9,-1,-1,4));
		MAP.put(new Input(new int[]{18,8,4,21,2,5,21,10,20,14,25,14,2,1,16},new int[]{6,4,6,7,1,2,12,9,10,10}),Arrays.asList(3,7,3,-1,-1,-1,7,2,-1,-1));
		MAP.put(new Input(new int[]{21,4,3,8,19,25,12,7,6,14,4,21,4,12,5,21},new int[]{9,3,10,1,4,9,3,8,1,8,4,4}),Arrays.asList(-1,-1,2,5,-1,-1,-1,-1,5,-1,-1,-1));
		MAP.put(new Input(new int[]{4,24,13,8,12,18,3,13,4,15,6,22,1,19,21,2,21},new int[]{4,8,4,14,7,11,4,6,3,5,13,2,15}),Arrays.asList(-1,8,-1,2,5,-1,-1,-1,-1,-1,-1,5,-1));
	}

	@BeforeAll
	public static void setup()
	{
		generateTestCases();
	}

	@Test
	@Timeout(3)
	void solveQueries()
	{
		for (Map.Entry<Input, List<Integer>> entry : MAP.entrySet())
		{
			final int[] ints = entry.getKey().ints();
			final int[] queries = entry.getKey().queries();
			final List<Integer> expected = entry.getValue();
			final List<Integer> actual = ClosestEqualElementQueries.solveQueries(ints, queries);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Ints", Arrays.toString(ints),
				"Queries", Arrays.toString(queries),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}

	// runtime generated test cases to avoid large static array literals exceeding JVM limits
	private static void generateTestCases()
	{
		final int intsLength = ThreadLocalRandom.current().nextInt(1, 100_000);
		final int queriesLength = ThreadLocalRandom.current().nextInt(1, intsLength);
		final int maxValue = 1_000_000;

		for (int i = 0; i < 50; i++)
		{
			int[] ints = DataUtils.generateArray(IntArraySpec.builder(intsLength).bounds(1, maxValue).build());
			int[] queries = DataUtils.generateArray(IntArraySpec.builder(queriesLength).randomSizeUpTo().bounds(0, queriesLength).build());
			List<Integer> expected = validate(ints, queries);
			MAP.put(new Input(ints, queries), expected);
		}
	}

	// from LC editorial
	private static List<Integer> validate(int[] nums, int[] queries)
	{
		int n = nums.length;
		HashMap<Integer, ArrayList<Integer>> numsPos = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			numsPos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
		}
		for (ArrayList<Integer> pos : numsPos.values())
		{
			int x = pos.get(0);
			int last = pos.get(pos.size() - 1);
			pos.add(0, last - n);
			pos.add(x + n);
		}
		List<Integer> result = new ArrayList<>();
		for (int q : queries)
		{
			int x = nums[q];
			ArrayList<Integer> posList = numsPos.get(x);

			if (posList.size() == 3)
			{
				result.add(-1);
				continue;
			}

			int idx = Collections.binarySearch(posList, q);
			if (idx < 0)
			{
				idx = -idx - 1;
			}

			int dist = Math.min(
				posList.get(idx + 1) - posList.get(idx),
				posList.get(idx) - posList.get(idx - 1)
			);
			result.add(dist);
		}
		return result;
	}
}
record Input(int[] ints, int[] queries)
{

}