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
long long maxProfit(int* prices, int pricesSize, int* strategy, int strategySize, int k)
{
	long long baseProfit = 0;
	for (int i = 0; i < pricesSize; i++)
	{
		baseProfit += (long long)strategy[i] * prices[i];
	}

	if (k > pricesSize || k == 0)
	{
		return baseProfit;
	}

	long long maxGain = 0;
	int half = k / 2;

	long long* leftEffect = (long long*) malloc(pricesSize * sizeof(long long));
	long long* rightEffect = (long long*) malloc(pricesSize * sizeof(long long));

	for (int i = 0; i < pricesSize; i++)
	{
		leftEffect[i] = -(long long) strategy[i] * prices[i];
		rightEffect[i] = (long long) prices[i] - (long long) strategy[i] * prices[i];
	}

	for (int i = 0; i <= pricesSize - k; i++)
	{
		long long gain = 0;

		for (int j = i; j < i + half; j++)
		{
			gain += leftEffect[j];
		}

		for (int j = i + half; j < i + k; j++)
		{
			gain += rightEffect[j];
		}

		if (gain > maxGain)
		{
			maxGain = gain;
		}
	}

	free(leftEffect);
	free(rightEffect);

	return baseProfit + maxGain;
}