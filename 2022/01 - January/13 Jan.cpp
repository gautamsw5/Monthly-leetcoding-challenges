class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int n = points.size();
        int ans = 0, i = 0;
        while(i < n) {
            vector<int> cur = points[i++];
            while(i < n && max(cur[0], points[i][0]) <= min(cur[1], points[i][1])) {
                cur[0] = max(cur[0], points[i][0]);
                cur[1] = min(cur[1], points[i][1]);
                i++;
            }
            ans++;
        }
        return ans;
    }
};
