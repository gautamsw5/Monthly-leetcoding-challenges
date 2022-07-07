class Solution:
    def solve(self, i, j):
        if i == self.n and j == self.m:
            return 1
        elif self.dp[i][j] != None:
            return self.dp[i][j]
        elif i == self.n:
            self.dp[i][j] = (self.s2[j:] == self.s3[i+j:])
            return self.dp[i][j]
        elif j == self.m:
            self.dp[i][j] = (self.s1[i:] == self.s3[i+j:])
            return self.dp[i][j]
        else:
            if self.s3[i+j] == self.s1[i] and self.solve(i+1, j):
                self.dp[i][j] = 1
                return self.dp[i][j]
            if self.s3[i+j] == self.s2[j] and self.solve(i, j+1):
                self.dp[i][j] = 1
                return self.dp[i][j]
        self.dp[i][j] = 0
        return self.dp[i][j]
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        self.n, self.m = len(s1), len(s2)
        self.s1 = s1
        self.s2 = s2
        self.s3 = s3
        if len(s3) != self.n+self.m:
            return 0
        self.dp = [[None for j in range(self.m+1)] for i in range(self.n+1)]
        return self.solve(0, 0)
