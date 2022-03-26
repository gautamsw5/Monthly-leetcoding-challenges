class Solution {
    public int search(int[] a, int t)
    {
        int i=0,j=a.length-1;
        if(a[j]==t)
        {
            return j;
        }
        while(i+1<j)
        {
            int m=(i+j)/2;
            if(a[m]==t)
            {
                return m;
            }
            else if(a[m]>t)
            {
                j=m;
            }
            else
            {
                i=m;
            }
        }
        if(a[i]==t)
        {
            return i;
        }
        if(j>0 && a[j-1]==t)
        {
            return j-1;
        }
        return -1;
    }
}
