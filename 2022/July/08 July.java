class Solution {
    Integer[][][] dp;
    int[] houses;
    int[][] cost;
    int n, m;
    int solve(int i, int k, int p) {
        // System.out.println(Arrays.toString(houses) + " " + k);
        if(i == m && k == 0) {
            return 0;
        }
        else if(i == m || k < 0) return 1000001;
        else if(dp[i][p][k] != null) return dp[i][p][k];
        else if(houses[i] != 0) {
            if(houses[i] != p) dp[i][p][k] = solve(i+1, k-1, houses[i]);
            else dp[i][p][k] = solve(i+1, k, houses[i]);
        }
        else {
            dp[i][p][k] = 1000001;
            for(int j = 0; j < n; j++) {
                if(i > 0 && j+1 == p) {
                    // houses[i] = j+1;
                    dp[i][p][k] = Math.min(dp[i][p][k], solve(i+1, k, j+1) + cost[i][j]);
                    // houses[i] = 0;
                }
                else {
                    // houses[i] = j+1;
                    dp[i][p][k] = Math.min(dp[i][p][k], solve(i+1, k-1, j+1) + cost[i][j]);
                    // houses[i] = 0;
                }
            }
        }
        return dp[i][p][k];
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new Integer[m][n+1][target+1];
        this.houses = houses;
        this.cost = cost;
        this.n = n;
        this.m = m;
        int ans = solve(0, target, 0);
        // System.out.println(Arrays.deepToString(dp));
        if(ans > 1000000) return -1;
        else return ans;
    }
}
