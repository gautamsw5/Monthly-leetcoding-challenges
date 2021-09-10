class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        this.arr = arr;
        n = arr.length;
        dp = new Integer[n][n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int x = 2+solve(i, j); // Path length
                // System.out.println(arr[i]+" "+arr[j]+" "+x);
                ans += x-2;
            }
        }
        return ans;
    }
    Integer[][] dp;
    int n;
    int[] arr;
    int solve(int i, int j) {
        if(dp[i][j] != null)
            return dp[i][j];
        dp[i][j] = 0;
        for(int k = j+1; k < n; k++)
            if((long)arr[j]-arr[i] == (long)arr[k]-arr[j])
                dp[i][j] += 1+solve(j, k);
        return dp[i][j];
    }
}
