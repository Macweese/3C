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
long long maximumProfit(int* prices, int pricesSize, int k)
{
	int n = pricesSize;

	long long* hold = (long long*) malloc((k + 1) * sizeof(long long));
	long long* short_pos = (long long*) malloc((k + 1) * sizeof(long long));
	long long* empty = (long long*) malloc((k + 1) * sizeof(long long));

	for (int j = 0; j <= k; j++)
	{
		empty[j] = 0;
		hold[j] = -prices[0];
		short_pos[j] = prices[0];
	}

	for (int i = 1; i < n; i++)
	{
		for (int j = k; j >= 1; j--)
		{
			long long new_empty = empty[j];
			long long sell_profit = hold[j] + prices[i];
			long long close_short = short_pos[j] - prices[i];

			if (sell_profit > new_empty)
			{
				new_empty = sell_profit;
			}
			if (close_short > new_empty)
			{
				new_empty = close_short;
			}

			long long new_hold = hold[j];
			long long buy = empty[j - 1] - prices[i];
			if (buy > new_hold)
			{
				new_hold = buy;
			}

			long long new_short = short_pos[j];
			long long open_short = empty[j - 1] + prices[i];
			if (open_short > new_short)
			{
				new_short = open_short;
			}

			empty[j] = new_empty;
			hold[j] = new_hold;
			short_pos[j] = new_short;
		}
	}

	long long result = empty[k];

	free(hold);
	free(short_pos);
	free(empty);

	return result;
}
