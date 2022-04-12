class Solution
{
    private int countlive(int[][] board, int i,int j)
    {
        int x=0;
        //i-1,j-1,i+1,j+1,i,j
        if(j>0)
        {
            x=x+board[i][j-1];
        }
        if(i>0)
        {
            x=x+board[i-1][j];
            if(j>0)
            x=x+board[i-1][j-1];
        }
        if(j<board[0].length-1)
        {
            x=x+board[i][j+1];
            if(i>0)
            x=x+board[i-1][j+1];
        }
        if(i<board.length-1)
        {
            x=x+board[i+1][j];
            if(j>0)
            x=x+board[i+1][j-1];
            if(j<board[0].length-1)
            x=x+board[i+1][j+1];
        }
        return x;
    }
    public void gameOfLife(int[][] board)
    {
        int[][] grid = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int x = countlive(board,i,j);
                if(board[i][j]==1 && x<2)
                {
                    grid[i][j]=0;
                }
                else if(board[i][j]==1 && x>3)
                {
                    grid[i][j]=0;
                }
                else if(board[i][j]==0 && x==3)
                {
                    grid[i][j]=1;
                }
                else
                {
                    grid[i][j]=board[i][j];
                }
            }
        }
        int x=0;
        for(int[] i:grid)
        board[x++]=i;
    }
}
