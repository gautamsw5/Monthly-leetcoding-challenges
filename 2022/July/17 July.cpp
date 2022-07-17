class Solution {
public:
    int kInversePairs(int n, int k) {
        if(k == 0) return 1;
        int mod = 1000000007;
        vector<int> prev(k+1, 0);
        for(int i = 0; i < n; i++) {
            vector<int> dp(k+1, 0);
            dp[0] = 1;
            for(int j = 1; j < k+1; j++) {
                if(j-min(j, i)-1 < 0) dp[j] = (dp[j] + prev[j]) % mod;
                else dp[j] = (dp[j] + prev[j] - prev[j-min(j, i)-1]) % mod;
                dp[j] = (dp[j] + dp[j-1]) % mod;
            }
            prev = dp;
        }
        return (prev[k]-prev[k-1] + mod) % mod;
    }
};
