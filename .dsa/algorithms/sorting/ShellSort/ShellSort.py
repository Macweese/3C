#
#      Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
#
#      This program is free software: you can redistribute it and/or modify
#      it under the terms of the GNU Affero General Public License as
#      published by the Free Software Foundation, either version 3 of the
#      License, or (at your option) any later version.
#
#      This program is distributed in the hope that it will be useful,
#      but WITHOUT ANY WARRANTY; without even the implied warranty of
#      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#      GNU Affero General Public License for more details.
#
#      You should have received a copy of the GNU Affero General Public License
#      along with this program.  If not, see <http://www.gnu.org/licenses/>.
def shellSort(arr):
	n = len(arr)
	gap = int(n / 2)
	while gap > 0:
		for i in range(gap, n):
			temp = arr[i]
			j = i
			while j >= gap and arr[j - gap] > temp:
				arr[j] = arr[j - gap]
				j -= gap
			arr[j] = temp
		gap = int(gap / 2)


arr = [12, 34, 54, 2, 3]
shellSort(arr)
print(arr)