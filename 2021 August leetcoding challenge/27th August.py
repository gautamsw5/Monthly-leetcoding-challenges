def isSub(a, b): # Is 'a' a subsequence of 'b' ?
    i = 0
    j = 0
    while i < len(a) and j < len(b):
        if a[i] == b[j]:
            i += 1
            j += 1
        else:
            j += 1
    return i  == len(a)
class Solution:
    def findLUSlength(self, arr: List[str]) -> int:
        mx = 0
        for i in range(len(arr)):
            f = True
            for j in range(len(arr)):
                if i != j and isSub(arr[i], arr[j]):
                    f = False
                    break
            if f and mx < len(arr[i]):
                mx = len(arr[i])
        if mx == 0:
            return -1
        return mx
