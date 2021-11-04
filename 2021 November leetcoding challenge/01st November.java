class Solution
{
    boolean[][] vis;
    void bfs(char[][] board, int i, int j)
    {
        boolean f = true;
        if(board[i][j]=='X' || vis[i][j])
            return;
        Queue<int[]> que = new LinkedList<>();
        List<int[]> mark = new ArrayList<>();
        que.add(new int[]{i, j});
        while(!que.isEmpty())
        {
            int[] cur = que.remove();
            
            if(cur[0]==0 || cur[1]==0 || cur[0]==board.length-1 || cur[1]==board[cur[0]].length-1)
                f = false;
            if(!vis[cur[0]][cur[1]])
            {
                vis[cur[0]][cur[1]] = true;
                mark.add(cur);
                if(cur[0]+1 < board.length && !vis[cur[0]+1][cur[1]] && board[cur[0]+1][cur[1]]!='X')
                    que.add(new int[]{cur[0]+1, cur[1]});
                if(cur[1]+1 < board[cur[0]].length && !vis[cur[0]][cur[1]+1] && board[cur[0]][cur[1]+1]!='X')
                    que.add(new int[]{cur[0], cur[1]+1});
                if(cur[0] > 0 && !vis[cur[0]-1][cur[1]] && board[cur[0]-1][cur[1]]!='X')
                    que.add(new int[]{cur[0]-1, cur[1]});
                if(cur[1] > 0 && !vis[cur[0]][cur[1]-1] && board[cur[0]][cur[1]-1]!='X')
                    que.add(new int[]{cur[0], cur[1]-1});
            }
        }
        if(f)
            for(int[] z : mark)
                board[z[0]][z[1]] = 'X';
    }
    public void solve(char[][] board)
    {
        vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                bfs(board, i, j);
    }
}
