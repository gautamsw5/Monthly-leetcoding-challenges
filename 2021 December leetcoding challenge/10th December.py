class Solution:
    def numTilings(self, n: int) -> int:
        mod = 10**9 + 7
        dp = [0, 1, 2, 5]
        for i in range(4, n+1):
            dp.append((dp[i-1]*2 + dp[i-3]) % mod)
        return dp[n]
