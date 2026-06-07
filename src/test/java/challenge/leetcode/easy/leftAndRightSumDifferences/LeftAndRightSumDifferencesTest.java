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

package challenge.leetcode.easy.leftAndRightSumDifferences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Administrator
 * @Created 08:01 Sat 06 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2574. Left and Right Sum Differences")
class LeftAndRightSumDifferencesTest
{
	static Stream<Arguments> testCaseProvider()
	{
		return Stream.of(
			arguments(new int[]{10,4,8,3},new int[]{15,1,11,22}),
			arguments(new int[]{1},new int[]{0})
		);
	}

	@ParameterizedTest(name = "Case {index}: Input={0}, Expected={1}")
	@MethodSource("testCaseProvider")
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	void leftRightDifferences(int[] input, int[] expected)
	{
		final int[] actual = LeftAndRightSumDifferences.leftRightDifferences(input);

		String message = String.format("Test failed for case:"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s ",
			"Input", Arrays.toString(input),
			"Expected", Arrays.toString(expected),
			"Actual", Arrays.toString(actual),
			""
		);

		assertArrayEquals(expected, actual, message);
	}
}