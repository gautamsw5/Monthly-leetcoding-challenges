from functools import lru_cache
class Solution:
    @lru_cache
    def solve(self, i):
        if i == self.n:
            return 1
        elif i > self.n:
            return 0
        return self.solve(i+1) + self.solve(i+2)
    def climbStairs(self, n: int) -> int:
        self.n = n
        return self.solve(0)
