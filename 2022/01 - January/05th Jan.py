class Solution:
    
    def findPalins(self, l, r):
        while l >= 0 and r < self.n and self.s[l] == self.s[r]:
            self.isPali[l][r] = True
            l -= 1
            r += 1
    
    def solve(self, i):
        if i == self.n:
            self.ans.append(list(self.cur))
            
        for j in range(i, self.n):
            if self.isPali[i][j]:
                self.cur.append(self.s[i:j+1])
                self.solve(j+1)
                self.cur.pop(-1)
        
    
    def partition(self, s: str) -> List[List[str]]:
        self.s = s
        self.n = n = len(s)
        self.isPali = isPali = [[False for i in range(n)] for j in range(n)]
        for i in range(n):
            self.findPalins(i, i)
            if i < n-1 and s[i] == s[i+1]:
                self.findPalins(i, i+1)
        self.ans = []
        self.cur = []
        self.solve(0)
        return self.ans
