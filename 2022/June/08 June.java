class Solution {
    public int removePalindromeSub(String S)
    {
        if(S.length()==0)
        {
            return 0;
        }
        char[] s = S.toCharArray();
        int i=0,j=s.length-1;
        while(i<j)
        {
            if(s[i++]!=s[j--])
            {
                return 2;
            }
        }
        return 1;
    }
}
