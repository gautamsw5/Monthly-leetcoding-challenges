class Solution {
    boolean solve(int x, int k, int mask, int[] arr, int n, int s, boolean[] dp) {
        if(k == 0) return true;
        if(dp[mask]) return false;
        for(int i = 0; i < n; i++) {
            if((mask & (1<<i)) == 0 && x >= arr[i]) {
                if(x == arr[i] && solve(s, k-1, mask | (1<<i), arr, n, s, dp)) return true;
                else if(solve(x-arr[i], k, mask | (1<<i), arr, n, s, dp)) return true;
            }
        }
        dp[mask] = true;
        return false;
    }
    boolean canPartitionKSubsets(int[] arr, int k) {
        int s = 0, n = arr.length; for(int i = 0; i < n; i++) s += arr[i];
        if(s % k != 0)
            return false;
        s /= k;
        for(int i = 0; i < n; i++) if(arr[i] > s) return false;
        boolean[] dp = new boolean[1<<n];
        return solve(s, k, 0, arr, n, s, dp);
    }
}
