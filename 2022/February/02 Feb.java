class Solution {
    public List<Integer> findAnagrams(String S, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freqP = new int[26], freqS = new int[26];
        for(char c : p.toCharArray()) {
            freqP[c-'a']++;
        }
        char[] s = S.toCharArray();
        int k = p.length();
        for(int i = 0; i < k && i < s.length; i++) {
            freqS[s[i]-'a']++;
        }
        if(Arrays.equals(freqP, freqS)) ans.add(0);
        for(int i = k; i < s.length; i++) {
            freqS[s[i-k]-'a']--;
            freqS[s[i]-'a']++;
            if(Arrays.equals(freqP, freqS)) ans.add(i-k+1);
        }
        return ans;
    }
}
