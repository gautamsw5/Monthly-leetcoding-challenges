class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 2:
            return [i for i in range(n)]
        adj = [set() for i in range(n)]
        for u, v in edges:
            adj[u].add(v)
            adj[v].add(u)
        leaves = []
        for i in range(n):
            if len(adj[i]) == 1:
                leaves.append(i)
        while n > 2:
            n -= len(leaves)
            for i in range(len(leaves)):
                u = leaves.pop(0)
                v = adj[u].pop()
                adj[v].remove(u)
                if len(adj[v]) == 1:
                    leaves.append(v)
        return leaves
