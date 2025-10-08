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

package utils;

public enum SortingMode
{

	INCREASING,     		// synonym of INCREASING && UNIQUE		[0,2,3,4,5,6,7,8,9]
	STRICTLY_INCREASING,	// synonym of INCREASING && UNIQUE		[0,2,3,4,5,6,7,8,9]
	NON_DECREASING, 		// synonym of INCREASING				[1,1,1,1,1,1,1,5,6]
	DECREASING,     		// synonym of DECREASING && UNIQUE		[9,8,7,6,5,4,3,2,0]
	STRICTLY_DECREASING,	// synonym of DECREASING && UNIQUE		[9,8,7,6,5,4,3,2,0]
	NON_INCREASING, 		// synonym of DECREASING				[9,7,7,7,7,4,3,3,1]
	UNSORTED,
	SHUFFLED,
	;

	public boolean isAscending()
	{
		return this == INCREASING
			|| this == NON_DECREASING
			|| this == STRICTLY_INCREASING;
	}

	public boolean isDescending()
	{
		return this == DECREASING
			|| this == NON_INCREASING
			|| this == STRICTLY_DECREASING;
	}

	public boolean isStrict()
	{
		return this == STRICTLY_INCREASING
			|| this == STRICTLY_DECREASING;
	}

	public boolean isOrdered()
	{
		return isAscending() || isDescending();
	}

	public boolean isUnsorted()
	{
		return this == UNSORTED;
	}

	public boolean isShuffled()
	{
		return this == SHUFFLED;
	}
}