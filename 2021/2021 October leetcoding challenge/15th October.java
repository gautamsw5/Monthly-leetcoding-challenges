class Solution {
    int solve(int i) {
        if(i >= n) return 0;
        if(dp[i] != null) return dp[i];
        dp[i] = solve(i+1);
        for(int j = i+1; j < n; j++)
            dp[i] = Math.max(dp[i], arr[j]-arr[i] + solve(j+2));
        return dp[i];
    }
    int maxProfit(int[] arr) {
        this.arr = arr;
        n = arr.length;
        dp = new Integer[n];
        return solve(0);
    }
    int[] arr;
    int n;
    Integer[] dp;
}
