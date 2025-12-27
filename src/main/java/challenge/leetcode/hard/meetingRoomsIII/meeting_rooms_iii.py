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

class Solution:
	def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
		meetings.sort()

		idle = list(range(n))
		busy = []
		count = [0] * n

		for start, end in meetings:
			while busy and busy[0][0] <= start:
				_, room = heappop(busy)
				heappush(idle, room)

			if idle:
				room = heappop(idle)
				count[room] += 1
				heappush(busy, (end, room))
			else:
				end_time, room = heappop(busy)
				count[room] += 1
				heappush(busy, (end_time + end - start, room))

		max_count = max(count)
		for i in range(n):
			if count[i] == max_count:
				return i