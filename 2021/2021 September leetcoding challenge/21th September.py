class Solution:
    def findMaxConsecutiveOnes(self, arr: List[int]) -> int:
        i = 0
        ans = 0
        n = len(arr)
        while i < n:
            c = 0
            while i < n and arr[i] == 1:
                i += 1
                c += 1
            ans = max(ans, c)
            i += 1
        return ans
