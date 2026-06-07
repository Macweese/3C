/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.medium.rotatingTheBox;

/**
 * @author Administrator
 * @Created 23:48 Wed 06 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class RotatingTheBox
{
	public static char[][] rotateTheBox(char[][] box)
	{
		int m = box.length;
		int n = box[0].length;
		char[][] ans = new char[n][m];

		for (int i = 0; i < m; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				ans[j][m - i - 1] = box[i][j];
			}
		}

		for (int j = 0; j < m; ++j)
		{
			int write = n - 1;
			for (int i = n - 1; i >= 0; --i)
			{
				if (ans[i][j] == '*')
				{
					write = i - 1;
				}
				else if (ans[i][j] == '#')
				{
					ans[i][j] = '.';
					ans[write][j] = '#';
					write--;
				}
			}
		}

		return ans;
	}
}
