class Solution {
    boolean solve(int i, int[] arr, int n, Boolean[] dp) {
        if(i == n-1)
            return true;
        if(dp[i] != null) return dp[i];
        for(int j = i+1; j < Math.min(n, i+arr[i]+1); j++) {
            if(solve(j, arr, n, dp)) {
                dp[i] = true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }
    boolean canJump(int[] arr) {
        int n = arr.length;
        Boolean[] dp = new Boolean[n];
        return solve(0, arr, n, dp);
    }
}
