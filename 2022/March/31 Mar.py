class Solution:
    
    def check(self, m, n):
        c = 0
        i = 0
        while i < self.n:
            x = 0
            while i < self.n and x+self.arr[i] <= m:
                x += self.arr[i]
                i += 1
            c += 1
            if c > n:
                return 0
        return 1
    
    def splitArray(self, arr: List[int], n: int) -> int:
        self.arr = arr
        self.n = len(arr)
        l, r = min(arr), sum(arr)
        while l <= r:
            m = (l+r)//2
            b = self.check(m, n)
            if b and not self.check(m-1, n):
                return m
            elif b:
                r = m-1
            else:
                l = m+1
        return -1
