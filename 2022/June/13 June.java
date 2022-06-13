class Solution {
    List<List<Integer>> mat;
    Integer[][] dp;
    int n;
    int solve(int i, int j) {
        if(i == n) return 0;
        if(dp[i][j] != null) return dp[i][j];
        dp[i][j] = mat.get(i).get(j) + solve(i+1, j);
        if(i+1 < n && j+1 < mat.get(i+1).size()) dp[i][j] = Math.min(dp[i][j], mat.get(i).get(j) + solve(i+1, j+1));
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        mat = triangle;
        n = mat.size();
        dp = new Integer[n][n];
        return solve(0, 0);
    }
}
