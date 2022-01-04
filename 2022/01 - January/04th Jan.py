class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n == 0:
            return 1
        N = 0
        p = 1
        while n > 0:
            N = N + (1 - n % 2)*p
            p = p*2
            n = n // 2
        return N
