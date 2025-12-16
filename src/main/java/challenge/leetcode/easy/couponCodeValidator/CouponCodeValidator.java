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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Administrator
 * @Created 07:11 Sat 13 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CouponCodeValidator
{
	private static final Map<String, Integer> INDUSTRY_PRIORITY = Map.of(
		"electronics", 0,
		"grocery", 1,
		"pharmacy", 2,
		"restaurant", 3
	);

	private static final Set<String> VALID_INDUSTRIES = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));

	public static List<String> validateCoupons(String[] codes, String[] businessLines, boolean[] isActive)
	{
		return IntStream.range(0, codes.length)
			.mapToObj(i -> new Coupon(codes[i], businessLines[i].toLowerCase(), isActive[i]))
			.filter(coupon -> coupon.active()
				&& !coupon.code().isEmpty()
				&& coupon.code().matches("^[a-zA-Z0-9_]+$")
				&& INDUSTRY_PRIORITY.containsKey(coupon.industry()))
			.sorted(Comparator
				.<Coupon>comparingInt(coupon -> INDUSTRY_PRIORITY.getOrDefault(coupon.industry(), Integer.MAX_VALUE))
				.thenComparing(Coupon::code))
			.map(Coupon::code)
			.toList();
	}

	/**
	 * This extracts and returns the valid codes, but not in the requested order.
	 * @param codes
	 * @param businessLines
	 * @param isActive
	 * @return
	 */
	public static List<String> alternativeSolution(String[] codes, String[] businessLines, boolean[] isActive)
	{
		List<String> validCodes = new ArrayList<>();

		nextCode: for (int i = 0; i < isActive.length; i++)
		{
			if (!isActive[i])
			{
				codes[i] = "";
				businessLines[i] = "";
				continue;
			}

			if (!VALID_INDUSTRIES.contains(businessLines[i]))
			{
				codes[i] = "";
				continue;
			}

			if (codes[i].isBlank())
			{
				continue;
			}

			for (char c : codes[i].toCharArray())
			{
				if (!(Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c) || c == '_'))
				{
					continue nextCode;
				}
			}

			validCodes.add(codes[i]);
		}

		return validCodes;
	}
}

record Coupon(String code, String industry, boolean active)
{
}
