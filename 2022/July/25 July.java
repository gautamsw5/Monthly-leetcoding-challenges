class Solution {
    public int[] searchRange(int[] a, int t)
    {
        int[] b = new int[2];
        b[0]=-1;
        b[1]=-1;
        int l=0,r=a.length-1,m=0;
        while(l<=r)
        {
            m=(l+r)/2;
            if(a[m]>t)
            {
                r=m-1;
            }
            else if(a[m]<t)
            {
                l=m+1;
            }
            else
            {
                int c1=m,c2=m;
                while(c1>0 && a[c1-1]==t)
                {
                    c1--;
                }
                b[0]=c1;
                while(c2<a.length-1 && a[c2+1]==t)
                {
                    c2++;
                }
                b[1]=c2;
                break;
            }
        }
        return b;
    }
}
