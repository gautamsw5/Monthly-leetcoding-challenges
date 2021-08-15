import java.util.*;
class Solution
{
    void incr(int[] freq, char c)
    {
        if(c >= 'a' && c <= 'z')
            freq[c - 'a']++;
        else
            freq[c - 'A' + 26]++;
    }
    void decr(int[] freq, char c)
    {
        if(c >= 'a' && c <= 'z')
            freq[c - 'a']--;
        else
            freq[c - 'A' + 26]--;
    }
    int get(int[] freq, char c)
    {
        if(c >= 'a' && c <= 'z')
            return freq[c - 'a'];
        else
            return freq[c - 'A' + 26];
    }
    boolean containsAll(int[] freqWin, int[] freqT)
    {
        for(int i = 0; i < 52; i++)
            if(freqT[i] > freqWin[i])
                return false;
        return true;
    }
    public String minWindow(String S, String T)
    {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int l = 0, r = 0, L = -1, R = 2*s.length;
        int[] freqT = new int[52];
        for(char c : t)
            incr(freqT, c);
        int[] freqWin = new int[52];
        while(r < s.length)
        {
            while(r < s.length && !containsAll(freqWin, freqT))
                incr(freqWin, s[r++]);
            while(l < r && get(freqWin, s[l]) > get(freqT, s[l]))
                decr(freqWin, s[l++]);
            if(containsAll(freqWin, freqT) && r-l < R-L)
            {
                L = l;
                R = r;
            }
            // System.out.println(l + " " + r);
            r = ++l;
            freqWin = new int[52];
        }
        if(L == -1 || R == -1)
            return "";
        return S.substring(L, R);
    }
}
