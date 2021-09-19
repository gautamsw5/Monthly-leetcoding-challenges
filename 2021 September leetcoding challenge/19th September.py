class Solution:
    def solve(self, i, j):
        if j == self.m:
            return 1
        if i == self.n:
            return 0
        if self.dp[i][j] != None:
            return self.dp[i][j]
        if self.s[i] == self.t[j]:
            self.dp[i][j] = self.solve(i+1, j+1) + self.solve(i+1, j)
        else:
            self.dp[i][j] = self.solve(i+1, j)
        return self.dp[i][j]
    def numDistinct(self, s: str, t: str) -> int:
        (self.s, self.t, self.n, self.m) = (s, t, len(s), len(t))
        self.dp = [[None for j in range(self.m)] for i in range(self.n)]
        return self.solve(0, 0)
