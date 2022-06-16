class Solution
{
    public String longestPalindrome(String S)
    {
        char[] s = S.toCharArray();
        int m = 1;
        int x = 0, y = 1;
        for(int i = 0; i < s.length; i++)
        {
            int l = i, r = i;
            while(l >= 0 && r < s.length && s[l] == s[r]) {
                l--;
                r++;
            }
            l++;
            if(r - l > m) {
                m = r - l;
                x = l;
                y = r;
            }
            
            if(i+1 < s.length && s[i] == s[i+1]) {
                l = i;
                r = i+1;
                while(l >= 0 && r < s.length && s[l] == s[r]) {
                    l--;
                    r++;
                }
                l++;
                if(r - l > m) {
                    m = r - l;
                    x = l;
                    y = r;
                }
            }
            
        }
        return S.substring(x,y);
    }
}
