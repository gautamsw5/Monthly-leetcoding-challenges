class Solution
{
    public int numSubmatrixSumTarget(int[][] matrix, int target)
    {
        int n=matrix.length,
        m=matrix[0].length,
        ans=0;
        int[][] dp = new int[n][m];
        dp[0][0]=matrix[0][0];
        for(int j=1; j<m; j++)
        {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for(int i=1; i<n; i++)
        {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
            for(int j=1; j<m; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i][j] - dp[i-1][j-1];
            }
        }
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                for(int R=r;R<n;R++)
                {
                    for(int C=c;C<m;C++)
                    {
                        int v = dp[R][C];
                        if(r>0)
                        {
                            v -= dp[r-1][C];
                        }
                        if(c>0)
                        {
                            v -= dp[R][c-1];
                        }
                        if(r>0 && c>0)
                        {
                            v += dp[r-1][c-1];
                        }
                        if(v==target)
                        {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
