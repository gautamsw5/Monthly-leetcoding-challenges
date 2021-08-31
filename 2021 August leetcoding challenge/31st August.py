class Solution:
    def findMin(self, arr: List[int]) -> int:
        n = len(arr)
        l, r = 0, n-1
        while l <= r:
            m = (l+r)//2
            if arr[m] <= arr[n-1] and arr[m] <= arr[(m-1)%n]:
                return arr[m]
            elif arr[m] > arr[-1]:
                l = m+1
            else:
                r = m
