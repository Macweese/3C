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
package challenge.leetcode.easy.defangingAnIpAddress;

/**
 * @author Administrator
 * @Created 24/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1108
 * @Name Defanging an IP Address
 * @Difficulty Easy
 * @Tags string
 * weekly contest 144
 * @link <a href="https://leetcode.com/problems/defanging-an-ip-address/">www.leetcode.com/1108</a>
 * @Description Given a valid (IPv4) IP <code>address</code>, return a defanged version of that IP address.<br>
 *
 * <br>A <i>defanged IP address</i> replaces every period <code>"."</code> with <code>"[.]"</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code address = "1.1.1.1"}
 * 			<br><b>Output:</b> {@code "1[.]1[.]1[.]1"}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> address = "255.100.50.0"}
 * 			<br><b>Output:</b> "255[.]100[.]50[.]0"}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li>The given <code>address</code> is a valid IPv4 address.</li>
 * </ul>
 * </p>
 **/
public class DefangingAnIPAddress
{
	public static String defangIPaddr(String address)
	{
		return address.replaceAll("\\.", "[.]");
	}
}
