class Solution {
    public int longestValidParentheses(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        for(int i = 0; i < s.length; i++) {
            int x = 0;
            int j = i;
            while(j < s.length) {
                if(s[j] == '(') x++;
                else x--;
                if(x < 0) break;
                j++;
                if(x == 0) ans = Math.max(ans, j-i);
            }
        }
        return ans;
    }
}
