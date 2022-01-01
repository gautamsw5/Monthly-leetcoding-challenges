class Solution:
    def numTrees(self, N: int) -> int:
        self.dp = [None]*(N+1)
        def solve(n):
            if n<=1:
                return 1
            if self.dp[n]!=None:
                return self.dp[n]
            ret = 0
            for i in range(0, n):
                ret += solve(i)*solve(n-i-1)
            self.dp[n] = ret
            return ret
        return solve(N)
