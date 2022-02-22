class Solution {
    public int titleToNumber(String s)
    {
        int ans = 0, n=0;
        while(n<s.length())
        {
            ans+=(s.charAt(n)-'A'+1)*(int)Math.pow(26,s.length()-n-1);
            n++;
        }
        return ans;
    }
}
