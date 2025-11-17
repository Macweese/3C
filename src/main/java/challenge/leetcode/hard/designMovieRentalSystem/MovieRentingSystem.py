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

from sortedcontainers import SortedList

class MovieRentingSystem:

	def __init__(self, n: int, entries: List[List[int]]):

		self.store = defaultdict(int)
		self.films = defaultdict(SortedList)
		self.rental = set()

		for shop, movie, price in entries:
			self.store[(shop, movie)] = price
			self.films[movie].add((price, shop))


	def search(self, movie: int) -> List[int]:
		return list(map(lambda x: x[1], self.films[movie][:5]))


	def rent(self, shop: int, movie: int) -> None:

		price = self.store[(shop, movie)]
		self.films[movie].discard((price, shop))
		self.rental.add((price, shop, movie))
		return


	def drop(self, shop: int, movie: int) -> None:

		price = self.store[(shop, movie)]
		self.films[movie].add((price, shop))
		self.rental.discard((price, shop, movie))

		return


	def report(self) -> List[List[int]]:

		report_stores = sorted(self.rental)[:5]
		return list(map(lambda x: (x[1], x[2]), report_stores))