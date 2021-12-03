class Solution:
    def maxProduct(self, arr: List[int]) -> int:
        ans = arr[0]
        l, r, n = 0, 0, len(arr)
        while l < n:
            while l < n and arr[l] == 0:
                ans = max(ans, arr[l])
                l += 1
            r = l
            if l < n:
                p = arr[l]
                ans = max(ans, p)
            while r+1 < n and arr[r+1] != 0:
                p = p * arr[r+1]
                r += 1
                ans = max(ans, p)
            while l < r:
                p = p // arr[l]
                l += 1
                ans = max(ans, p)
            l = r + 1
        return ans
