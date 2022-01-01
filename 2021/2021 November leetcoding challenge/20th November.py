class Solution:
    def singleNonDuplicate(self, arr: List[int]) -> int:
        xor = 0
        for i in arr:
            xor ^= i
        return xor
