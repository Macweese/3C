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

package challenge.leetcode.medium.rotatingTheBox;

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
 * @Created 23:48 Wed 06 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1861. Rotating the Box")
class RotatingTheBoxTest
{
	static Stream<Arguments> testCaseProvider()
	{
		return Stream.of(
			arguments(new char[][]{{'#','.','#'}},new char[][]{{'#','.','#'}}),
			arguments(new char[][]{{'#','.','*','.'},{'#','#','*','.'}},new char[][]{{'#','.'},{'#','#'},{'*','*'},{'.','.'}}),
			arguments(new char[][]{{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}},new char[][]{{'.','#','#'},{'.','#','#'},{'#','#','*'},{'#','*','.'},{'#','.','*'},{'#','.','.'}})
			);
	}

	@ParameterizedTest(name = "Case {index}: Input={0}, Expected={1}")
	@MethodSource("testCaseProvider")
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	void testCase(char[][] input, char[][] expected)
	{
		RotatingTheBox.rotateTheBox(input);

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