class Solution
{
    private boolean[][] visited;
    private int area(int[][] grid, int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || visited[i][j])
        {
            return 0;
        }
        visited[i][j]=true;
        int
        d=area(grid,i+1,j),
        b=area(grid,i,j+1),
        a=area(grid,i-1,j),
        c=area(grid,i,j-1);
        return 1+d+b+a+c;
    }
    public int maxAreaOfIsland(int[][] grid)
    {
        if(grid.length==0 || grid[0].length==0)
        {
            return 0;
        }
        int max=0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int ar=area(grid,i,j);
                    max=Math.max(max,ar);
                }
            }
        }
        return max;
    }
}
