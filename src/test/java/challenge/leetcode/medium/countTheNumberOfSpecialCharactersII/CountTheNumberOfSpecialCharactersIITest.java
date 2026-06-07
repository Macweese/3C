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

package challenge.leetcode.medium.countTheNumberOfSpecialCharactersII;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Administrator
 * @Created 22:47 Wed 27 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3121. Count the Number of Special Characters II")
class CountTheNumberOfSpecialCharactersIITest
{
	static Stream<Arguments> testCaseProvider()
	{
		return Stream.of(
			arguments("aaAbcBC",3),
			arguments("abc",0),
			arguments("AbBCab",0),
			arguments("aAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaA",0),
			arguments("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",26),
			arguments("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",0),
			arguments("aaaaabbbbbcccccdddddeeeeeAAAAABBBBBCCCCCDDDDDEEEEE",5),
			arguments("aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ",26),
			arguments("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzZz",0),
			arguments("aabcdefghijklmnopqrstuvwxyzZYXWVUTSRQPONMLKJIHGFEDCBA",26),
			arguments("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAAa",0),
			arguments("cCceDC",0),
			arguments("dcbCC",1),
			arguments("deE",1),
			arguments("eEb",1)
		);
	}

	@ParameterizedTest(name = "Case {index}: Input={0}, Expected={1}")
	@MethodSource("testCaseProvider")
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	void testCase(String input, int expected)
	{
		final int actual = CountTheNumberOfSpecialCharactersII.numberOfSpecialChars(input);

		String message = String.format("Test failed for case:"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s ",
			"Input", input,
			"Expected", expected,
			"Actual", actual,
			""
		);

		assertEquals(expected, actual, message);
	}
}