class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        adj = [[0, 1], [0, -1], [1, 0], [-1, 0], [1, 1], [1, -1], [-1, 1], [-1, -1]]
        if grid[0][0] == 1 or grid[-1][-1] == 1:
            return -1
        que = [(0, 0, 1)]
        while que:
            i, j, d = que.pop(0)
            if i == len(grid) - 1 and j == len(grid[0]) - 1:
                return d
            if grid[i][j] == 2:
                continue
            grid[i][j] = 2
            for x, y in adj:
                if 0 <= i + x and i + x < len(grid) and 0 <= j + y and j + y < len(grid[0]) and grid[i + x][j + y] == 0:
                    que.append((i + x, j + y, d + 1))
        return -1
