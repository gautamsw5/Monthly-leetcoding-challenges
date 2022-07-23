from bisect import *
class Solution:
    def countSmaller(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans = [0]*n
        brr = []
        for i in range(n-1, -1, -1):
            x = bisect_left(brr, arr[i])
            ans[i] = x
            insort(brr, arr[i])
        return ans
