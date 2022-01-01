class Solution:
    def findComplement(self, n: int) -> int:
        bits = []
        while n > 0:
            bits = [1 - n % 2] + bits
            n = n // 2
        ans = 0
        for bit in bits:
            ans = ans*2 + bit
        return ans
