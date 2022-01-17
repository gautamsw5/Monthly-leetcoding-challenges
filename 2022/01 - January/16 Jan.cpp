class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int prev = -1, ans = 0, z = 0;
        for(int i = 0; i < seats.size(); i++) {
            if(seats[i] == 0) {
                z++;
                if(prev == -1) ans = max(ans, z);
            }
            else {
                if(prev != -1) ans = max(ans, (i-prev)/2);
                prev = i;
                z = 0;
            }
        }
        ans = max(ans, z);
        return ans;
    }
};
