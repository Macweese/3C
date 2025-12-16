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

package challenge.leetcode.easy.couponCodeValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:12 Sat 13 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3606. Coupon Code Validator")
class CouponCodeValidatorTest
{
	private static final Map<Triple<String[], String[], boolean[]>, List<String>> MAP = new HashMap<>();

	static
	{
		MAP.put(new ImmutableTriple<>(new String[]{"SAVE20","","PHARMA5","SAVE@20"},new String[]{"restaurant","grocery","pharmacy","restaurant"},new boolean[]{true,true,true,true}),List.of("PHARMA5","SAVE20"));
		MAP.put(new ImmutableTriple<>(new String[]{"GROCERY15","ELECTRONICS_50","DISCOUNT10"},new String[]{"grocery","electronics","invalid"},new boolean[]{false,true,true}),List.of("ELECTRONICS_50"));
		MAP.put(new ImmutableTriple<>(new String[]{"1OFw","0MvB"},new String[]{"electronics","pharmacy"},new boolean[]{true,true}),List.of("1OFw","0MvB"));
		MAP.put(new ImmutableTriple<>(new String[]{"a","aa","b","bb","c","cc","11","10","0","1","1OFw","0MvB"},new String[]{"electronics","electronics","electronics","electronics","electronics","electronics","electronics","electronics","electronics","electronics","electronics","pharmacy"},new boolean[]{true,true,true,true,true,true,true,true,true,true,true,true}),List.of("0", "1", "10", "11", "1OFw", "a", "aa", "b", "bb", "c", "cc", "0MvB"));
//		MAP.put(new ImmutableTriple<>(new String[]{},new String[]{},new boolean[]{}),List.of());
//		MAP.put(new ImmutableTriple<>(new String[]{},new String[]{},new boolean[]{}),List.of());
	}

	@Test
	void validateCoupons()
	{
		for (Map.Entry<Triple<String[], String[], boolean[]>, List<String>> entry : MAP.entrySet())
		{
			final String[] codes = entry.getKey().getLeft();
			final String[] businessLines = entry.getKey().getMiddle();
			final boolean[] isActive = entry.getKey().getRight();

			assert codes.length == businessLines.length  && codes.length == isActive.length;

			final List<String> expected = entry.getValue();
			final List<String> actual = CouponCodeValidator.validateCoupons(codes, businessLines, isActive);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Codes", Arrays.toString(codes),
				"Industry", Arrays.toString(businessLines),
				"Active", Arrays.toString(isActive),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertIterableEquals(expected, actual, message);
		}
	}
}