class Solution:
    
    def find(self, x):
        c = 0
        for i in range(1, self.m+1):
            c += min(x // i, self.n)
        return c >= self.k
    
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        self.n, self.m, self.k = n, m, k
        l, r = 1, n*m
        while l < r:
            m = (l + r) // 2
            if self.find(m):
                r = m
            else:
                l = m + 1
        return l
