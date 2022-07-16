class Solution {
    int n, m, mod;
    Integer[][][] dp;
    int solve(int i, int j, int moves) {
        if(i < 0 || j < 0 || i >= n || j >= m) return 1;
        if(moves == -1) return 0;
        if(dp[i][j][moves] != null) return dp[i][j][moves];
        dp[i][j][moves] = solve(i+1, j, moves-1) % mod;
        dp[i][j][moves] = (dp[i][j][moves] + solve(i-1, j, moves-1) % mod) % mod;
        dp[i][j][moves] = (dp[i][j][moves] + solve(i, j+1, moves-1) % mod) % mod;
        dp[i][j][moves] = (dp[i][j][moves] + solve(i, j-1, moves-1) % mod) % mod;
        return dp[i][j][moves];
    }
    public int findPaths(int n, int m, int maxMove, int startRow, int startColumn) {
        this.n = n;
        this.m = m;
        dp = new Integer[n][m][maxMove];
        mod = 1000000007;
        return solve(startRow, startColumn, maxMove-1);
    }
}
