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

import java.util.concurrent.ThreadLocalRandom;

public final class IntArraySpec
{
	public final int size;
	public final SizeMode sizeMode;
	public final int minInclusive;
	public final int maxInclusive;
	public final SortingMode sortingMode;

	private IntArraySpec(Builder b)
	{
		this.size = b.size;
		this.sizeMode = b.sizeMode;
		this.minInclusive = b.minInclusive;
		this.maxInclusive = b.maxInclusive;
		this.sortingMode = b.sortingMode;
	}

	public int resolveSize()
	{
		if (sizeMode == SizeMode.FIXED)
		{
			return Math.max(0, size);
		}

		return size <= 0 ? 0 : ThreadLocalRandom.current().nextInt(1, size + 1);
	}

	public static Builder builder(int size)
	{
		return new Builder(size);
	}

	public static final class Builder
	{
		private int size;
		private SizeMode sizeMode = SizeMode.FIXED;
		private int minInclusive = Integer.MIN_VALUE;
		private int maxInclusive = Integer.MAX_VALUE;
		private SortingMode sortingMode = SortingMode.UNSORTED;

		public Builder(int size)
		{
			this.size = size;
		}

		public Builder fixedSize()
		{
			this.sizeMode = SizeMode.FIXED;
			return this;
		}

		public Builder randomSizeUpTo()
		{
			this.sizeMode = SizeMode.RANDOM;
			return this;
		}

		public Builder bounds(int minInclusive, int maxInclusive)
		{
			this.minInclusive = minInclusive;
			this.maxInclusive = maxInclusive;
			return this;
		}

		public Builder lowerBound(int minInclusive)
		{
			this.minInclusive = minInclusive;
			return this;
		}

		public Builder upperBound(int maxInclusive)
		{
			this.maxInclusive = maxInclusive;
			return this;
		}

		public Builder sorting(SortingMode mode)
		{
			this.sortingMode = mode;
			return this;
		}

		public IntArraySpec build()
		{
			if (minInclusive > maxInclusive)
			{
				throw new IllegalArgumentException("minInclusive must be <= maxInclusive");
			}
			return new IntArraySpec(this);
		}
	}
}