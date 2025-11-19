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
n, m = list(map(int, input().split(" ")))
h = [0] + list(map(int, input().split(" ")))

size = n


def down(u):
	t = u
	if u * 2 <= size and h[u * 2] < h[t]:
		t = u * 2
	if u * 2 + 1 <= size and h[u * 2 + 1] < h[t]:
		t = u * 2 + 1
	if t != u:
		h[t], h[u] = h[u], h[t]
		down(t)


def up(u):
	while u // 2 > 0 and h[u // 2] > h[u]:
		h[u // 2], h[u] = h[u], h[u // 2]
		u //= 2


for i in range(n // 2, 0, -1):
	down(i)

res = []
for i in range(m):
	res.append(h[1])
	h[1] = h[size]
	size -= 1
	down(1)

print(' '.join(list(map(str, res))))