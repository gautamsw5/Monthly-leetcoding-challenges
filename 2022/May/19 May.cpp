class Solution {
public:
    vector<vector<int>> matrix;
    vector<vector<int>> dp;
    int n, m;
    int dfs(int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        dp[i][j] = 1;
        if(i+1 < n && matrix[i+1][j] > matrix[i][j]) dp[i][j] = max(dp[i][j], 1 + dfs(i+1, j));
        if(j+1 < m && matrix[i][j+1] > matrix[i][j]) dp[i][j] = max(dp[i][j], 1 + dfs(i, j+1));
        if(i > 0 && matrix[i-1][j] > matrix[i][j]) dp[i][j] = max(dp[i][j], 1 + dfs(i-1, j));
        if(j > 0 && matrix[i][j-1] > matrix[i][j]) dp[i][j] = max(dp[i][j], 1 + dfs(i, j-1));
        return dp[i][j];
    }
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        n = matrix.size(); m = matrix[0].size();
        this->matrix = matrix;
        dp = vector<vector<int>>(n, vector<int>(m, 0));
        int ans = 0;
        for(int i = 0; i < n; i++) for(int j = 0; j < m; j++) ans = max(ans, dfs(i, j));
        return ans;
    }
};
