class Solution:
    
    def pre(self, u):
        if self.vis[u]:
            return
        for v in self.adj[u]:
            self.pre(v)
        if self.vis[u] == 0:
            self.res.append(u)
            self.vis[u] = 1
    
    def findOrder(self, n: int, prerequisites: List[List[int]]) -> List[int]:
        self.adj = [[] for i in range(n)]
        for a, b in prerequisites:
            self.adj[b].append(a)
        self.vis = [0]*n
        self.res = []
        for i in range(n):
            if self.vis[i] == 0:
                try:
                    self.pre(i)
                except:
                    return []
        return self.res[::-1]
