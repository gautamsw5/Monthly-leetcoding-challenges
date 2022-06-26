class Solution:
    def maxScore(self, arr: List[int], k: int) -> int:
        n = len(arr)
        k = n - k
        ans = 0
        for i in range(k):
            ans += arr[i]
        s = ans
        for i in range(k, n):
            s += arr[i] - arr[i-k]
            ans = min(ans, s)
        return sum(arr) - ans
