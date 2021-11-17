class Solution:
    def solve(self, i, j):
        if i == self.n-1 and j == self.m-1:
            return 1
        if i == self.n or j == self.m:
            return 0
        if self.dp[i][j] != None:
            return self.dp[i][j]
        self.dp[i][j] = self.solve(i+1, j) + self.solve(i, j+1)
        return self.dp[i][j]
    def uniquePaths(self, m: int, n: int) -> int:
        self.n, self.m = n, m
        self.dp = [[None for j in range(m)] for i in range(n)]
        return self.solve(0, 0)
