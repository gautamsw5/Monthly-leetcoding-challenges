class Solution
{
    public int findMaxForm(String[] strs, int Z, int O)
    {
        int n = strs.length;
        int[][] dp = new int[Z+1][O+1];
        for(int x=0; x<n; x++)
        {
            int[] arr = new int[2];
            for(char c : strs[x].toCharArray())
            {
                arr[c-'0']++;
            }
            for(int i=Z; i>arr[0]-1; i--)
            {
                for(int j=O; j>arr[1]-1; j--)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i-arr[0]][j-arr[1]] + 1);
                }
            }
        }
        return dp[Z][O];
    }
}
