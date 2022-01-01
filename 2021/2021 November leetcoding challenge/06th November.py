class Solution:
    def singleNumber(self, arr: List[int]) -> List[int]:
        arr.sort()
        ans = []
        i, n = 0, len(arr)
        while i < n:
            if i+1 == n or arr[i] != arr[i+1]:
                ans.append(arr[i])
                i += 1
            else:
                i += 2
        return ans
