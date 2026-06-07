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

package challenge.leetcode.medium.rotateImage;

import java.util.Arrays;
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
 * @Created 07:06 Mon 04 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("48. Rotate Image")
class RotateImageTest
{
	static Stream<Arguments> testCaseProvider()
	{
		return Stream.of(
			arguments(new int[][]{{1,2,3},{4,5,6},{7,8,9}},new int[][]{{7,4,1},{8,5,2},{9,6,3}}),
			arguments(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}},new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}})
		);
	}

	@ParameterizedTest(name = "Case {index}: Input={0}, Expected={1}")
	@MethodSource("testCaseProvider")
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	void rotate(int[][] input, int[][] expected)
	{
		RotateImage.rotate(input);

		String message = String.format("Test failed for case:"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s ",
			"Input", Arrays.toString(input),
			"Expected", Arrays.toString(expected),
			"Actual", Arrays.toString(input),
			""
		);

		assertArrayEquals(expected, input, message);
	}

}