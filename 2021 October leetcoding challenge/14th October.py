from math import sqrt
class Solution:
    def numSquares(self, n: int) -> int:
        while n % 4 == 0:
            n = n // 4
        if n % 8 == 7:
            return 4
        x = int(sqrt(n))
        if x*x == n:
            return 1
        i = 1
        while i*i <= n:
            s = n - i*i
            x = int(sqrt(s))
            if x*x == s:
                return 2
            i += 1
        return 3
