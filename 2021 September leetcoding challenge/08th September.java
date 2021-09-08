class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] s = S.toCharArray();
        int shift = 0;
        for(int i = shifts.length-1; i >= 0 ; i--) {
            shift = (shift + shifts[i]) % 26;
            s[i] = (char)('a' + (s[i]-'a'+shift) % 26);
        }
        return new String(s);
    }
}
