class Solution:
    def findDuplicate(self, arr: List[int]) -> int:
        n = len(arr)
        freq = [0]*n
        for i in arr:
            if freq[i-1] == 1:
                return i
            freq[i-1] += 1
        return -1
