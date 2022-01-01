class Solution
{
    private boolean[][] vis;
    private char[] s;
    private char[][] board;
    private boolean dfs(int i, int j, int k)
    {
        if(k==s.length)
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j] != s[k] || vis[i][j])
            return false;
        vis[i][j] = true;
        boolean ans = dfs(i+1, j, k+1) || dfs(i, j+1, k+1) || dfs(i-1, j, k+1) || dfs(i, j-1, k+1);
        vis[i][j] = false;
        return ans;
    }
    public boolean exist(char[][] board, String word)
    {
        this.s = word.toCharArray();
        this.vis = new boolean[board.length][board[0].length];
        this.board = board;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                {
                    if(dfs(i, j, 0))
                        return true;
                }
        return false;
    }
}
