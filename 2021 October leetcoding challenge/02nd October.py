from functools import lru_cache
class Solution:
    def f(self, x):
        if x >= 0:
            return 1
        else:
            return 1-x
    @lru_cache
    def dfs(self, i, j):
        if i == self.n-1 and j == self.m-1:
            return self.f(self.A[i][j])
        M = 10**9
        if i+1 < self.n:
            M = min(M, self.dfs(i+1, j))
        if j+1 < self.m:
            M = min(M, self.dfs(i, j+1))
        return max(self.f(self.A[i][j]), M - self.A[i][j])
    def calculateMinimumHP(self, A: List[List[int]]) -> int:
        self.n = len(A)
        self.m = len(A[0])
        self.A = A
        return self.dfs(0, 0)
