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

package challenge.leetcode.hard.deleteColumnsToMakeSortedIII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 11:26 Wed 24 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("960. Delete Columns to Make Sorted III")
class DeleteColumnsToMakeSortedIIITest
{
	private static final Map<String[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new String[]{"edcba"},4);
		MAP.put(new String[]{"cbbdabc"},3);
		MAP.put(new String[]{"abcawxyz"},1);
		MAP.put(new String[]{"aaaaaaaaaaaaaaaaaaaa"},0);
		MAP.put(new String[]{"babca","bbazb"},3);
		MAP.put(new String[]{"ghi","def","abc"},0);
		MAP.put(new String[]{"zyxwvutsrq","yxwvutsrqp","xwvutsrqpo"},9);
		MAP.put(new String[]{"qwertyuiop","asdfghjklp","zxcvbnmqop"},7);
		MAP.put(new String[]{"babcbazbqwe", "bbazbzxcvbn", "bacbzqwerty"},8);
		MAP.put(new String[]{"aaabbbcccddd","aaabbbcccddd","aaabbbcccddd"},0);
		MAP.put(new String[]{"mmmmnnnnoooopppp","mmmnonnnoooopppp","mmmmnnnnoooopppp"},1);
		MAP.put(new String[]{"abcxyz","abcyzz","abcyzz","abcyzz"},0);
		MAP.put(new String[]{"azazazazaz","bzbzbzbzbz","czczczczcz","dzdzdzdzdz"},4);
		MAP.put(new String[]{"abcdefghijklmnopqrst","abcdefghijklmnopqrst","abcdefghijklmnopqrst"},0);
		MAP.put(new String[]{"abcdefghijabcdefghij", "abcdefghijabcdefghij", "abcdefghijabcdefghij"},9);
		MAP.put(new String[]{"abcdefghijklmnop","bbcdefghijklmnop","cbcdefghijklmnop","dbcdefghijklmnop"},1);
		MAP.put(new String[]{"qweasdzxcvqwertyuioplkjhgfdsamnbvcxzpoiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnfjasjkdjkqdwjksjkdas", "mnbvcxzlkjhgfdsapoiuytrewqzxcvbnmlkjhgfdsaqwertyuiopqazwsxedcrfvtgbyhnujmikloasjfhasfjhasjhfahsjfasd", "poiuytrewqlkjhgfdsamnbvcxzqazwsxedcrfvtgbyhnujmiklopqweasdzxcvpoiuytrewqlkjhgasasfasfwfzhfhgjdfgjsdf", "asdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiopzxcvbnmasdagasehygjhkjzgzdfas"},96);
	}

	@Test
	void minDeletionSize()
	{
		for (Map.Entry<String[], Integer> entry : MAP.entrySet())
		{
			final String[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = DeleteColumnsToMakeSortedIII.minDeletionSize(input);

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