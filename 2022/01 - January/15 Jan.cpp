class Solution {
public:
    int minJumps(vector<int>& arr) {
        unordered_map<int, vector<int>> index;
        int n = arr.size();
        if(n == 1) return 0;
        if(arr[0] == arr[n-1]) return 1;
        for(int i = 0; i < n; i++) {
            index[arr[i]].push_back(i);
        }
        queue<int> q;
        vector<bool> vis(n, 0);
        q.push(0);
        int d = 0;
        while (!q.empty()) {
            int t = q.size();
            while (t--) {
                int u = q.front();
                if(u == n-1) return d;
                q.pop();
                if(vis[u]) continue;
                vis[u] = 1;                
                if(u > 0 && vis[u-1] == 0) q.push(u-1);
                if(u < n-1 && vis[u+1] == 0) q.push(u+1);
                for(int v : index[arr[u]]) {
                    if(!vis[v]) q.push(v);
                }
                index[arr[u]].clear();
            }
            d++;
        }
        return d;
    }
};
