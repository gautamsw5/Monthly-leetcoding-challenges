class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+2][n+2];
        for(int i = 0; i < n; i++) {
            for(int l = 0; l < n - i; l++) {
                int r = l + i;
                for(int k = l; k < r+1; k++) {
                    int a = 1, b = 1;
                    if(l > 0) a = arr[l-1];
                    if(r+1 < n) b = arr[r+1];
                    dp[l+1][r+1] = Math.max(dp[l+1][r+1], a*arr[k]*b + dp[l+1][k] + dp[k+2][r+1]);
                }
            }
        }
        return dp[1][n];
    }
}