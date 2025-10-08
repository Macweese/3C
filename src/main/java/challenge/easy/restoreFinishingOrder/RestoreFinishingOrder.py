class Solution:
    def recoverOrder(self, order: List[int], friends: List[int]) -> List[int]:
        sorted_list = []

        for i in order:
            j = self._binary_search(friends, i)
            if j != -1 and i == friends[j]:
                sorted_list.append(i)

        return sorted_list

    def _binary_search(self, ints: List[int], value: int) -> int:
        l = 0
        r = len(ints) - 1

        while l <= r:
            m = l + (r - l) // 2

            if ints[m] == value:
                return m

            if ints[m] < value:
                l = m + 1
            else:
                r = m - 1

        return -1