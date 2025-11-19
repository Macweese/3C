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
def insertion_sort(array):
	for i in range(len(array)):
		cur_index = i
		while array[cur_index - 1] > array[cur_index] and cur_index - 1 >= 0:
			array[cur_index], array[cur_index - 1] = (
				array[cur_index - 1],
				array[cur_index],
			)
			cur_index -= 1
	return array


array = [10, 17, 50, 7, 30, 24, 27, 45, 15, 5, 36, 21]
print(insertion_sort(array))
