class Solution:
    def sortArrayByParityII(self, arr: List[int]) -> List[int]:
        n = len(arr)
        (i, j) = (0, 1)
        while i < n and j < n:
            while i < n and i%2 == arr[i]%2:
                i += 2
            while j < n and j%2 == arr[j]%2:
                j += 2
            if i < n and j < n:
                (arr[i], arr[j]) = (arr[j], arr[i])
        return arr
