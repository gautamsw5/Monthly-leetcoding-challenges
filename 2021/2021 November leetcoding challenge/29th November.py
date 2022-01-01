from collections import defaultdict
class Solution:
    def dfs(self, u):
        if u in self.vis:
            return
        self.t.append(u)
        self.vis.add(u)
        for v in self.graph[u]:
            self.dfs(v)
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        self.graph = defaultdict(set)
        name = {}
        for i in range(len(accounts)):
            name[accounts[i][1]] = accounts[i][0]
            self.graph[accounts[i][1]]
            for j in range(2, len(accounts[i])):
                name[accounts[i][j]] = accounts[i][0]
                self.graph[accounts[i][j-1]].add(accounts[i][j])
                self.graph[accounts[i][j]].add(accounts[i][j-1])
        self.vis = set()
        ans = []
        for mail in self.graph:
            if not mail in self.vis:
                self.t = []
                self.dfs(mail)
                ans.append([name[mail]] + sorted(self.t))
        return ans
