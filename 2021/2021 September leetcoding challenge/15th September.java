class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 0, n = arr.length;
        int[][] dp = new int[n][];
        if(n > 0) {
            dp[0] = new int[]{1, 1};
            ans = 1;
            for(int i = 1; i < n; i++) {
                dp[i] = new int[]{1, 1};
                if(arr[i] > arr[i-1]) {
                    dp[i][0] = 1 + dp[i-1][1];
                    ans = Math.max(ans, dp[i][0]);
                }
                else if(arr[i] < arr[i-1]) {
                    dp[i][1] = 1 + dp[i-1][0];
                    ans = Math.max(ans, dp[i][1]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}
