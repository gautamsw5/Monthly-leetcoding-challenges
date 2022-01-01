class Solution
{
    public boolean isValidSudoku(char[][] board)
    {
        for(int i = 0; i < 9; i++)
        {
            int[] freqR = new int[10];
            int[] freqC = new int[10];
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    if(freqR[board[i][j]-'0'] == 1)
                        return false;
                    freqR[board[i][j]-'0']++;
                }
                if(board[j][i] != '.')
                {
                    if(freqC[board[j][i]-'0'] == 1)
                        return false;
                    freqC[board[j][i]-'0']++;
                }
            }
        }
        for(int i = 0; i < 7; i += 3)
        {
            for(int j = 0; j < 7; j += 3)
            {
                int[] freq = new int[10];
                for(int x = i; x < i+3; x++)
                {
                    for(int y = j; y < j+3; y++)
                    {
                        if(board[x][y] != '.')
                        {
                            if(freq[board[x][y]-'0'] == 1)
                                return false;
                            freq[board[x][y]-'0']++;
                        }
                    }
                }
            }
        }
        return true;
    }
}
