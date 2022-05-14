class Solution:
    def networkDelayTime(self, edges: List[List[int]], n: int, k: int) -> int:
        adj = [[] for _ in range(n+1)]
        for u, v, w in edges:
            adj[u].append((v, w))
        q = [(k, 0)]
        dist = [float('inf')] * (n+1)
        dist[k] = 0
        dist[0] = 0
        while q:
            u, d = q.pop(0)
            for v, w in adj[u]:
                if dist[v] > d + w:
                    dist[v] = d + w
                    q.append((v, dist[v]))
        return max(dist) if max(dist) != float('inf') else -1
