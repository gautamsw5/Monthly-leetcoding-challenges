class Solution:
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        ans = 0
        mod = 10**9 + 7
        f = [0]*301
        for i in arr:
            f[i] += 1
        for i in range(target+1):
            for j in range(0, i+1):
                k = target - i - j
                if k >= i and k >= j:
                    if i != j and j != k and i != k:
                        ans = (ans + f[i]*f[j]*f[k]) % mod
                    elif i == j and j == k:
                        ans = (ans + (f[i]*(f[i]-1)*(f[i]-2)) // 6) % mod
                    elif i == j:
                        ans = (ans + (f[i]*(f[i]-1)*f[k])//2) % mod
                    elif i == k:
                        ans = (ans + (f[i]*(f[i]-1)*f[j])//2) % mod
                    elif j == k:
                        ans = (ans + (f[j]*(f[j]-1)*f[i])//2) % mod
        return ans
