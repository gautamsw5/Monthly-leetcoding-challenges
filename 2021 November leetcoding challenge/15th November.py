class Solution:
    
    def largestDivisibleSubset(self, arr: List[int]) -> List[int]:
        self.arr = arr
        arr.sort()
        n = self.n = len(arr)
        adj = self.adj = defaultdict(list)
        indeg = defaultdict(int)
        for i in range(n):
            for j in range(i+1, n):
                if arr[i] != arr[j] and arr[j] % arr[i] == 0:
                    adj[i].append(j)
                    indeg[j] += 1
        dp = self.dp = [0]*n
        ans = []
        for i in range(n):
            self.solve(i)
        for i in range(n):
            if indeg[i] == 0:
                path = self.getLongestPath(i)
                if len(path) > len(ans):
                    ans = path
        return ans
    
    def solve(self, i):
        if self.dp[i]:
            return self.dp[i]
        self.dp[i] = 1
        for j in range(i+1, self.n):
            if self.arr[j] != self.arr[i] and self.arr[j] % self.arr[i] == 0:
                self.dp[i] = max(self.dp[i], 1 + self.solve(j))
        return self.dp[i]
    
    def getLongestPath(self, i):
        path = [self.arr[i]]
        f = 1
        while f:
            f = 0
            for j in self.adj[i]:
                if self.dp[j] + 1 == self.dp[i]:
                    path.append(self.arr[j])
                    i = j
                    f = 1
                    break
        return path
