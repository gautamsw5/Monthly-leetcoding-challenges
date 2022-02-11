class Solution {
    public boolean checkInclusion(String S1, String S2) {
        char[] s1 = S1.toCharArray();
        char[] s2 = S2.toCharArray();
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (char c : s1) {
            f1[c - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s2.length) {
            if (l > r) {
                Arrays.fill(f2, 0);
                r = l;
            }
            if (f2[s2[l] - 'a'] > f1[s2[l] - 'a']) {
                f2[s2[l++] - 'a']--;
            }
            else {
                f2[s2[r++] - 'a']++;
            }
            if (Arrays.equals(f1, f2)) {
                return true;
            }
        }
        return false;
    }
}
