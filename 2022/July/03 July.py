class Solution:
    def wiggleMaxLength(self, arr: List[int]) -> int:
        ans = 0
        n = len(arr)
        if n == 0:
            return ans
        
        x = 1
        i = 1
        while i < n:
            while i < n and arr[i] >= arr[i-1]:
                i += 1
            if i < n:
                x += 1
                i += 1
            while i < n and arr[i] <= arr[i-1]:
                i += 1
            if i < n:
                x += 1
                i += 1
        ans = max(ans, x)
        
        x = 1
        i = 1
        while i < n:
            while i < n and arr[i] <= arr[i-1]:
                i += 1
            if i < n:
                x += 1
                i += 1
            while i < n and arr[i] >= arr[i-1]:
                i += 1
            if i < n:
                x += 1
                i += 1
        ans = max(ans, x)
        
        return ans
