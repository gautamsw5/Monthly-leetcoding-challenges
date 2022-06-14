class Solution:
    def minDistance(self, a: str, b: str) -> int:
        n, m = len(a), len(b)
        dp = [[0 for j in range(m+1)] for i in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, m+1):
                if a[i-1] == b[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return n+m-2*dp[n][m]
