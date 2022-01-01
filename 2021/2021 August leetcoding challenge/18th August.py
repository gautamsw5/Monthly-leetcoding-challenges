class Solution:
    def numDecodings(self, S: str) -> int:
        self.dp = [None]*len(S)
        def solve(s, i):
            if i==len(s):
                return 1
            if self.dp[i] != None:
                return self.dp[i]
            ans = 0
            if s[i]>'0':
                ans += solve(s, i+1)
                if i+1<len(s) and int(s[i]+s[i+1]) < 27:
                    ans += solve(s, i+2)
            self.dp[i] = ans
            return ans
        return solve(S, 0)
