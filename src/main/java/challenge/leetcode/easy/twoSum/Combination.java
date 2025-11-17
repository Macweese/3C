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
package challenge.leetcode.easy.twoSum;

/**
 * The restriction to apply when returning addends.
 *
 * <ul>
 *     <li>
 *         {@link Combination#FIRST} - The any first
 *         combination of addends, which satisfy the given conditions.
 *     </li>
 *     <li>
 *         {@link Combination#COMBINATION} - All unique
 *         combinations of addends which satisfy the given conditions.
 *         <p>
 *             Given an array {@code ints = [0, -1, -1, 1, 2, 4]}, <br>with the conditions of
 *             2 addends and {@code COMBINATION}, finding solutions for the sum {@code 3} yields the following:<br>
 *             {@code 3 = [-1, 4]} where the indices reference<br>
 *             {@code ints[1]} and {@code ints[5]} respectively.
 *         </p>
 *     </li>
 *     <li>
 *         {@link Combination#PERMUTATION} - All compositions of a given set.
 *         <p>
 *             Given an array {@code ints = [0, -1, -1, 1, 2, 4]}, <br>with the conditions of
 *             2 addends, and {@code PERMUTATION} selected, finding solutions for the sum {@code 3} yields the following:
 *             <table>
 *                 <tr><td></td><td>{@code int a }</td><td>{@code int b }</td><td>{@code ref a }</td><td>{@code ref b }</td></tr>
 *                 <tr><td>Solution 1 = </td><td>{@code -1}</td><td>{@code 4}</td><td>{@code int[1]}</td><td>{@code int[5]}</td></tr>
 *                 <tr><td>Solution 2 = </td><td>{@code -1}</td><td>{@code 4}</td><td>{@code int[2]}</td><td>{@code int[5]}</td></tr>
 *                 <tr><td>Solution 3 = </td><td>{@code 4}</td><td>{@code -1}</td><td>{@code int[5]}</td><td>{@code int[1]}</td></tr>
 *                 <tr><td>Solution 4 = </td><td>{@code 4}</td><td>{@code -1}</td><td>{@code int[5]}</td><td>{@code int[2]}</td></tr>
 *             </table>
 *         </p>
 *     </li>
 * </ul>
 */
public enum Combination
{
	FIRST,
	COMBINATION,
	PERMUTATION,
}