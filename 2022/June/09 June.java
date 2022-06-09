class Solution {
    public int[] twoSum(int[] a, int t)
    {
        int[] r=new int[2];
        int i=0,j=a.length-1;
        while(i<j)
        {
            if(a[i]+a[j]==t)
            {
                r[0]=i+1;
                r[1]=j+1;
                return r;
            }
            else if(a[i]+a[j]<t)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return r;
    }
}
