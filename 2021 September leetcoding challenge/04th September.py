class Solution:
    
    def count_lower(self, u, p):
        """
        Assuming 0 as root, set count[i] = number of nodes below node i, including node i
        """
        ans = 0
        for v in self.adj[u]:
            if v != p:
                ans += self.count_lower(v, u)
        self.count[u] = 1+ans
        return 1+ans
    
    def solve_0(self, u, p, d):
        """
        Find the answer for node 0
        """
        self.ans[0] += d
        for v in self.adj[u]:
            if v != p:
                self.solve_0(v, u, d+1)
        
    def dfs(self, u, p):
        """
        Calculate the answer for other nodes reusing answer for previous node
        """
        self.ans[u] = self.ans[p] + self.n - 2*self.count[u]
        for v in self.adj[u]:
            if v != p:
                self.dfs(v, u)
        
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        
        self.adj = [[] for i in range(n)]
        self.n = n
        for e in edges:
            self.adj[e[0]].append(e[1])
            self.adj[e[1]].append(e[0])
        
        self.count = [0]*n
        self.count_lower(0, -1) # start at node 0
        # print(self.count)
        
        self.ans = [0]*n
        
        self.solve_0(0, -1, 0) # Solve for node 0
        
        for i in self.adj[0]:
            self.dfs(i, 0)
        
        return self.ans
