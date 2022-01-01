class Edge:
    def __init__(self, u, v, dist):
        self.u = u
        self.v = v
        self.dist = dist
        self.uReachable = 0
        self.vReachable = 0
        self.maxRem = 0

class Node:
    def __init__(self, val):
        self.val = val
        self.adj = []
        self.vis = False
        
class Solution:
    def reachableNodes(self, edges: List[List[int]], maxMoves: int, n: int) -> int:
        edgeSet = []
        nodes = [Node(i) for i in range(n)]
        for e in edges:
            edgeSet.append(Edge(e[0], e[1], e[2]))
            nodes[e[0]].adj.append([nodes[e[1]], edgeSet[-1]])
            nodes[e[1]].adj.append([nodes[e[0]], edgeSet[-1]])
        
        pq = [[-maxMoves, 0]]
        heapq.heapify(pq)
        while len(pq) > 0:
            cur = heapq.heappop(pq)
            u = cur[1]
            nodes[u].vis = True
            rem = -cur[0]
            for v in nodes[u].adj:
                (v, e) = (v[0].val, v[1])
                if rem >= e.dist+1:
                    e.uReachable = e.vReachable = e.dist
                    nodes[v].vis = True
                    if e.maxRem < rem-e.dist-1:
                        e.maxRem = rem-e.dist-1
                        heapq.heappush(pq, [e.dist+1-rem, v])
                else:
                    if e.u == u:
                        e.uReachable = max(e.uReachable, rem)
                    else:
                        e.vReachable = max(e.vReachable, rem)
            
        ans = 0
        for node in nodes:
            if node.vis:
                # print(node.val)
                ans += 1
                
        for e in edgeSet:
            # print(e.u, e.v, e.uReachable, e.vReachable)
            ans += min(e.dist, e.uReachable + e.vReachable)
        
        # print("")
        return ans
