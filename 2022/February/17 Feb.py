class Solution:
    def solve(self, i, x):
        if x==0:
            self.res.append(list(self.cur))
            return
        if x < 0 or i == self.n:
            return
        self.solve(i+1, x)
        for f in range(1, x // self.arr[i] + 1):
            self.cur.append(self.arr[i])
            self.solve(i+1, x-f*self.arr[i])
        for f in range(1, x // self.arr[i] + 1):
            self.cur.pop(-1)
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        (self.arr, self.res, self.cur, self.n) = (candidates, [], [], len(candidates))
        self.solve(0, target)
        return self.res
