class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[]{poured};
        for(int i = 0; i < query_row; i++) {
            double[] nextDP = new double[dp.length+1];
            for(int j = 0; j < dp.length; j++) {
                if(dp[j] > 1.0) {
                    nextDP[j] += (dp[j] - 1.0) / 2;
                    nextDP[j+1] += (dp[j] - 1.0) / 2;
                }
            }
            dp = nextDP;
        }
        return Math.min(1.0, dp[query_glass]);
    }
}
