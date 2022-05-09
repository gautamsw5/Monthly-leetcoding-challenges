class Solution:
    def solve(self, i, cur):
        if i == self.n:
            self.comb.append(cur)
            return
        for c in self.arr[int(self.d[i])]:
            self.solve(i+1, cur+c)
    def letterCombinations(self, digits: str) -> List[str]:
        self.arr = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        self.d = digits
        self.n = len(digits)
        self.comb = []
        if self.n:
            self.solve(0, "")
        return self.comb
