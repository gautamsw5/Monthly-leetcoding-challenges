class Solution
{
    int[] adj;
    int[][] grid;
    Integer[][][] dp;
    int solve(int x, int y1, int y2)
    {
        if(x == grid.length)
            return 0;
        if(dp[x][y1][y2] != null)
            return dp[x][y1][y2];
        int v = 0, ans = 0;
        if(y1==y2)
            v = grid[x][y1];
        else
            v = grid[x][y1] + grid[x][y2];
        for(int a : adj)
            for(int b : adj)
                if(y1 + a >= 0 && y1 + a < grid[x].length && y2 + b >= 0 && y2 + b < grid[x].length)
                    ans = Math.max(ans, v + solve(x+1, y1+a, y2+b));
        dp[x][y1][y2] = ans;
        return ans;
    }
    public int cherryPickup(int[][] grid)
    {
        this.grid = grid;
        adj = new int[]{-1, 0, 1};
        dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return solve(0, 0, grid[0].length-1);
    }
}
