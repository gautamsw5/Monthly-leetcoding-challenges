class Solution {
public:
    vector<int> t;
    vector<vector<int>> ans;
    void solve(int k, int n, int prev) {
        if(k == 0) {
            if(n == 0) {
                ans.push_back(t);
            }
            return;
        }
        for(int i = prev+1; i < 10 && i < n+1; i++) {
            t.push_back(i);
            solve(k-1, n-i, i);
            t.pop_back();
        }
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        t.clear();
        ans.clear();
        solve(k, n, 0);
        return ans;
    }
};
