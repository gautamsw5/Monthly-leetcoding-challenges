class Solution
{
    private int[][] map;
    private int[][] obs;
    private int getu(int m, int n)
    {
        if(obs[m-1][n-1]==1)
        {
            return 0;
        }
        if(m==1 && n==1)
        {
            return 1;
        }
        int c=0;
        if(n>1)
        {
            int t=0;
            if(map[m-1][n-2]!=0)
            {
                t=map[m-1][n-2];
            }
            else
            {
                t=getu(m,n-1);
                map[m-1][n-2]=t;
            }
            c=c+t;
        }
        if(m>1)
        {
            int t=0;
            if(map[m-2][n-1]!=0)
            {
                t=map[m-2][n-1];
            }
            else
            {
                t=getu(m-1,n);
                map[m-2][n-1]=t;
            }
            c=c+t;
        }
        return c;
    }
    public int uniquePathsWithObstacles(int[][] grid)
    {
        int m = grid.length,
        n = grid[0].length;
        map = new int[m][n];
        obs=grid;
        return getu(m,n);
    }
}
