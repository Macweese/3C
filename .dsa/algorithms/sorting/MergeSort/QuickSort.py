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
N = int(input())
nums = list(map(int, input().split()))


def quick_sort(nums, left, right):
	if left >= right:
		return
	i, j = left - 1, right + 1
	x = nums[(left + right) >> 1]
	while i < j:
		while 1:
			i += 1
			if nums[i] >= x:
				break
		while 1:
			j -= 1
			if nums[j] <= x:
				break
		if i < j:
			nums[i], nums[j] = nums[j], nums[i]
	quick_sort(nums, left, j)
	quick_sort(nums, j + 1, right)


quick_sort(nums, 0, N - 1)
print(' '.join(list(map(str, nums))))