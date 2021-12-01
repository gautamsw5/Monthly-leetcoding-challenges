class Solution:
    
    def solve(self, i):
        if i >= self.n:
            return 0
        if self.dp[i] != None:
            return self.dp[i]
        self.dp[i] = max(self.solve(i+1), self.arr[i] + self.solve(i+2))
        return self.dp[i]
    
    def rob(self, arr: List[int]) -> int:
        self.arr, self.n = arr, len(arr)
        self.dp = [None]*self.n
        return self.solve(0)
