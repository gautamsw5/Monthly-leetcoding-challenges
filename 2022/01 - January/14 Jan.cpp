class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        while(i < s.length() && s[i] == ' ') i++;
        long ans = 0, l = -(long)INT_MIN, r = INT_MAX;
        bool sign = 0;
        if(i < s.length()) {
            if(s[i] == '-') {
                sign = 1;
                i++;
            }
            else if(s[i] == '+') i++;
            while(i < s.length() && s[i] >= '0' && s[i] <= '9') {
                ans = ans*10 + ((int)s[i]-(int)'0');
                if(sign == 1 && ans > l) {
                    ans = l;
                    break;
                }
                else if(sign == 0 && ans > r) {
                    ans = r;
                    break;
                }
                i++;
            }
        }
        if(sign == 1) return -ans;
        else return ans;
    }
};
