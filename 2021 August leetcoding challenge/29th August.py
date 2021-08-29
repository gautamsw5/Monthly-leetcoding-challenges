class Solution:
    def minPatches(self, arr: List[int], n: int) -> int:
        s = 0
        ans = 0
        i = 0
        while i < len(arr) and s < n:
            if arr[i] <= s+1:
                s += arr[i]
                i += 1
            else:
                ans += 1
                s += s + 1
                
        while s < n:
            ans += 1
            s += s + 1
        return ans
