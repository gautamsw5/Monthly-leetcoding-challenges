class Solution:
    def arrangeCoins(self, n: int) -> int:
        # x^2 + x - 2n
        return int((math.sqrt(1+8*n) - 1) / 2)
