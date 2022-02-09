#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findPairs(vector<int>& arr, int k) {
        int ans = 0;
        unordered_map<int, int> freq;
        for(int i : arr) freq[i]++;
        if(k == 0) {
            for(auto e : freq) {
                if(e.second > 1) {
                    ans++;
                }
            }
        }
        else {
            for(auto e : freq) {
                if(freq.find(k+e.first) != freq.end()) {
                    ans++;
                }
            }
        }
        return ans;
    }
};
