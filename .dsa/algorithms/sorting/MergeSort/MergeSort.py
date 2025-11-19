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


def merge_sort(nums, left, right):
	if left >= right:
		return
	mid = (left + right) >> 1
	merge_sort(nums, left, mid)
	merge_sort(nums, mid + 1, right)
	tmp = []
	i, j = left, mid + 1
	while i <= mid and j <= right:
		if nums[i] <= nums[j]:
			tmp.append(nums[i])
			i += 1
		else:
			tmp.append(nums[j])
			j += 1
	while i <= mid:
		tmp.append(nums[i])
		i += 1
	while j <= right:
		tmp.append(nums[j])
		j += 1

	j = 0
	for i in range(left, right + 1):
		nums[i] = tmp[j]
		j += 1


merge_sort(nums, 0, N - 1)
print(' '.join(list(map(str, nums))))