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
package challenge.easy.convertTheTemperature;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Created 23/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2469
 * @Name Convert The Temperature
 * @Difficulty Easy
 * @Tags math
 * weekly contest 319
 * @link <a href="https://leetcode.com/problems/convert-the-temperature/">www.leetcode.com/2469</a>
 * @Description You are given a non-negative floating point number rounded to two decimal places <code>celsius</code>,
 * that denotes the <b>temperature in Celsius</b>.<br>
 * <br>You should convert Celsius into <b>Kelvin and Fahrenheit</b> and return it as an array ans = <code>[kelvin, fahrenheit]</code>.<br>
 * <br>Return the <i>array <code>ans</code></i>. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.<br>
 *
 * <br><b>Note that:</b>
 * <ul>
 *     <li><code>Kelvin = Celsius + 273.15</code></li>
 *     <li><code>Fahrenheit = Celsius * 1.80 + 32.00</code></li>
 * </ul>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code celsius = 36.50}
 * 			<br><b>Output:</b> {@code [309.65000,97.70000]}
 * 			<br><b>Explanation:</b> Temperature at 36.50 Celsius converted in Kelvin is 309.65 and converted in Fahrenheit is 97.70.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code celsius = 122.11}
 * 			<br><b>Output:</b> {@code [395.26000,251.79800]}
 * 			<br><b>Explanation:</b> Temperature at 122.11 Celsius converted in Kelvin is 395.26 and converted in Fahrenheit is 251.798.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>0 &le; celsius &le; 1000</code></li>
 * </ul>
 * </p>
 **/
public class ConvertTheTemperature
{
	private static final Logger log = LoggerFactory.getLogger(ConvertTheTemperature.class);

	static
	{
		BasicConfigurator.configure();
	}

	public static void main(String[] args)
	{

	}

	public static double[] convertTemperature(double c)
	{
		return new double[]{convertCelsiusToKelvin(c), convertCelsiusToFahrenheit(c)};
	}

	private static double convertCelsiusToKelvin(double c)
	{
		return c + 273.15;
	}

	private static double convertCelsiusToFahrenheit(double c)
	{
		return 1.8 * c + 32;
	}
}
