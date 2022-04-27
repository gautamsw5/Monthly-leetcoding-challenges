class Solution:
    def smallestStringWithSwaps(self, s: str, edges: List[List[int]]) -> str:
        n = len(s)
        adj = [[] for _ in range(n)]
        for i, j in edges:
            adj[i].append(j)
            adj[j].append(i)
        visited = [False] * n
        ans = [''] * n
        for i in range(n):
            if not visited[i]:
                q = [i]
                comp = []
                chars = []
                while q:
                    u = q.pop()
                    if visited[u]:
                        continue
                    visited[u] = True
                    comp.append(u)
                    chars.append(s[u])
                    for v in adj[u]:
                        if not visited[v]:
                            q.append(v)
            comp.sort()
            chars.sort()
            for j in range(len(comp)):
                ans[comp[j]] = chars[j]
        return ''.join(ans)
