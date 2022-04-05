class Solution:
    def maxArea(self, arr: List[int]) -> int:
        n = len(arr)
        (i, j) = (0, n-1)
        ans = 0
        while i < j:
            ans = max(ans, (j-i)*min(arr[i], arr[j]))
            if arr[i] < arr[j]:
                i += 1
            else:
                j -= 1
        return ans
