from functools import lru_cache
class Solution:
    @lru_cache(10000)
    def solve(self, i, a, b):
        if i == self.n:
            if a == b:
                return 0
            else:
                return 100000
        return min(self.arr[i][0] + self.solve(i+1, a+1, b), self.arr[i][1] + self.solve(i+1, a, b+1))
        
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        self.arr = costs
        self.n = len(costs)
        return self.solve(0, 0, 0)
