import java.util.*;
class Solution
{
    int[][] grid;
    int[][] dp;
    int n, count, idx;
    boolean[][] vis;
    List<int[]> getAdj(int i, int j)
    {
        List<int[]> adj = new ArrayList<>();
        if(i > 0 && grid[i-1][j]==1)
            adj.add(new int[]{i-1, j});
        if(j > 0 && grid[i][j-1]==1)
            adj.add(new int[]{i, j-1});
        if(i+1 < n && grid[i+1][j]==1)
            adj.add(new int[]{i+1, j});
        if(j+1 < n && grid[i][j+1]==1)
            adj.add(new int[]{i, j+1});
        return adj;
    }
    void dfs(int i, int j)
    {
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || vis[i][j])
            return;
        count++;
        dp[i][j] = idx;
        vis[i][j] = true;
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j-1);
        dfs(i, j+1);
    }
    int largestIsland(int[][] grid)
    {
        int ans = 1;
        n = grid.length;
        this.grid = grid;
        idx = 0;
        vis = new boolean[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        List<Integer> isLandLens = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!vis[i][j] && grid[i][j]==1)
                {
                    count = 0;
                    dfs(i, j);
                    idx++;
                    if(count > ans)
                        ans = count;
                    isLandLens.add(count);
                }
            }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j]==0)
                {
                    List<int[]> adj = getAdj(i, j);
                    Set<Integer> s = new HashSet<>();
                    for(int[] a : adj)
                        s.add(dp[a[0]][a[1]]);
                    int x = 1;
                    for(int k : s)
                        x += isLandLens.get(k);
                    if(x > ans)
                        ans = x;
                }
            }
        }
        return ans;
    }
}
