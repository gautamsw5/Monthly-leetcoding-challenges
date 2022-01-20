class Solution {
public:
    int getEatingHours(vector<int>& arr, int k) {
        int h = 0;
        for(int i : arr) {
            if(i % k == 0) h += i / k;
            else h += i / k + 1;
        }
        return h;
    }
    int minEatingSpeed(vector<int>& arr, int h) {
        // binary search k
        int l = 1, r = *max_element(arr.begin(), arr.end());
        while(l < r) {
            // cout<<l<<" "<<r<<endl;
            int m = (l+r)/2;
            if(getEatingHours(arr, m) <= h) r = m;
            else l = m + 1;
        }
        return l;
    }
};
