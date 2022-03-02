class Solution {
    public boolean isSubsequence(String S, String T)
    {
        int i=0,j=0,f=0,k=0;
        char []s=S.toCharArray();
        char []t=T.toCharArray();
        while(i<s.length)
        {
            k=j;
            f=0;
            while(k<t.length)
            {
                if(s[i]==t[k])
                {
                    j=k+1;
                    f=1;
                    break;
                }
                k++;
            }
            if(f==0)
            {
                return false;
            }
            i++;
        }
        return true;
    }
}
