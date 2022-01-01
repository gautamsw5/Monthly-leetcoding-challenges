class Solution:
    
    def solve(self, i, cur, v = 0):
        if i == self.n:
            if eval(cur) == self.v:
                self.ans.append(cur)
            return
        if self.s[i] == '0':
            if i == self.n-1:
                self.solve(i+1, cur + "0")
            else:
                self.solve(i+1, cur + "0*")
                self.solve(i+1, cur + "0+")
                self.solve(i+1, cur + "0-")
            return
        s = ""
        for j in range(i, self.n - 1):
            s += self.s[j]
            self.solve(j+1, cur + s + "*")
            self.solve(j+1, cur + s + "+")
            self.solve(j+1, cur + s + "-")
        if self.s[i] != '0':
            self.solve(self.n, cur + self.s[i:])
        
    def addOperators(self, s: str, v: int) -> List[str]:
        self.v = v
        self.s = s
        self.n = len(s)
        self.ans = []
        self.solve(0, "", 0)
        # print(self.ans)
        return self.ans
