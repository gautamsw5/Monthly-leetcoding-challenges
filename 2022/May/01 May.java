class Solution {
    public boolean backspaceCompare(String S, String T)
    {
        int i=0;
        while(i<S.length())
        {
            if(S.charAt(i)=='#' && i>1)
            {
                S=S.substring(0,i-1)+S.substring(i+1);
                i-=2;
            }
            else if(S.charAt(i)=='#' && i==1)
            {
                S=S.substring(2);
                i=-1;
            }
            else if(S.charAt(i)=='#' && i==0)
            {
                S=S.substring(1);
                i=-1;
            }
            i++;
        }
        i=0;
        while(i<T.length())
        {
            if(T.charAt(i)=='#' && i>1)
            {
                T=T.substring(0,i-1)+T.substring(i+1);
                i-=2;
            }
            else if(T.charAt(i)=='#' && i==1)
            {
                T=T.substring(2);
                i=-1;
            }
            else if(T.charAt(i)=='#' && i==0)
            {
                T=T.substring(1);
                i=-1;
            }
            i++;
        }
        return S.equals(T);
    }
}
