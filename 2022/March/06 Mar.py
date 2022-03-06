mod = 10**9 + 7
dp = [0, 1]
p = 6
d = 9
for i in range(2, 501):
    dp.append((dp[i-1]*p) % mod)
    p += d
    d += 4
    
class Solution:
    def countOrders(self, n: int) -> int:
        return dp[n]
