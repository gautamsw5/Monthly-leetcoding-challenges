class Solution
{
    int ans;
    char[] s;
    void expand(int l, int r)
    {
        while(l>=0 && r<s.length && s[l]==s[r])
        {
            l--; r++;
            ans++;
        }
    }
    public int countSubstrings(String S)
    {
        s = S.toCharArray();
        ans = 0;
        for(int i=0; i<s.length; i++)
        {
            expand(i,i+1);
            expand(i,i);
        }
        return ans;
    }
}
