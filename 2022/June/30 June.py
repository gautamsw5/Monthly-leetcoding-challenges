class Solution:
    def minMoves2(self, arr: List[int]) -> int:
        arr.sort()
        sr = sum(arr)
        sl = 0
        n = len(arr)
        ans = sr - (n-1)*arr[0]
        for i in range(n):
            sr -= arr[i]
            ans = min(ans, arr[i]*i - sl + sr - arr[i]*(n-i-1))
            sl += arr[i]
        return ans
