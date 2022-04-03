class Solution:
    
    def reverse(self, arr, i, j):
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
            
    def nextPermutation(self, arr: List[int]) -> None:
        n = len(arr)
        i = n - 1
        while i > 0 and arr[i] <= arr[i-1]:
            i -= 1
        if i == 0:
            self.reverse(arr, i, n-1)
            return
        i -= 1
        for j in range(n-1, i, -1):
            if arr[i] < arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
                break
        self.reverse(arr, i+1, n-1)
