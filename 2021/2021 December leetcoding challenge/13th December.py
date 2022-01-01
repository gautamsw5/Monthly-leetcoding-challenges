class Solution {
    public int maxPower(String S)
    {
        char[] s = S.toCharArray();
        int i=0,m=0,c;
        while(i<s.length)
        {
            c=1;
            while(i<s.length-1 && s[i]==s[i+1])
            {
                c++;
                i++;
            }
            if(c>m)
            {
                m=c;
            }
            i++;
        }
        return m;
    }
}
