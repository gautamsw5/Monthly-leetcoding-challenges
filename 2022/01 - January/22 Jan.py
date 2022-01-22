dp = [[None, None] for i in range(10**5+1)]
class Solution:
    def solve(self, n, p):
        if dp[n][p] != None:
            return dp[n][p]
        if dp[n][p^1] != None:
            return not dp[n][p^1]
        x = int(math.sqrt(n))
        if x*x == n or (x-1)*(x-1) == n or (x+1)*(x+1) == n:
            return p == 1
        if p == 0:
            for x in range(1, x+2):
                if x*x < n and not self.solve(n-x*x, p^1):
                    dp[n][p] = False
                    return False
            dp[n][p] = True
            return True
        else:
            for x in range(1, x+2):
                if x*x < n and self.solve(n-x*x, p^1):
                    dp[n][p] = True
                    return True
            dp[n][p] = False
            return False
    def winnerSquareGame(self, n: int) -> bool:
        return self.solve(n, 1)
