class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int l = 0, r = -1, ans = 0;
        Set<Character> set = new HashSet<>();
        while(r+1 < s.length) {
            if(set.contains(s[r+1])) {
                set.remove(s[l++]);
            }
            else {
                set.add(s[++r]);
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
