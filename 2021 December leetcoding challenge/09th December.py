class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        que = [start]
        n = len(arr)
        vis = [0]*n
        while que:
            cur = que.pop(0)
            if arr[cur] == 0:
                return True
            if cur + arr[cur] < n and vis[cur + arr[cur]] == 0:
                que.append(cur + arr[cur])
            if cur - arr[cur] >= 0 and vis[cur - arr[cur]] == 0:
                que.append(cur - arr[cur])
            vis[cur] = 1
        return False
