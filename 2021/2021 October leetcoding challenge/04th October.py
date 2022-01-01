class Solution:
    def countAdj(self, grid, i, j):
        ans = 0
        for dx, dy in self.adj:
            if i+dx < len(grid) and i+dx >= 0 and j+dy < len(grid[i]) and j+dy >= 0:
                ans += grid[i+dx][j+dy]
        # print(i, j, ans)
        return ans
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        self.adj = [(0, -1), (0, 1), (-1, 0), (1, 0)]
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j]:
                    ans += 4 - self.countAdj(grid, i, j)
        return ans
