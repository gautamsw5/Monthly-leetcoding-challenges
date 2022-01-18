class Solution {
    boolean allZeros(int[] a) {
        for(int i : a) if(i == 1) return false;
        return true;
    }
    public boolean canPlaceFlowers(int[] a, int n)
    {
        int i=0,count=0;
        int curr=0;
        if(a[0]==0)
        {
            if(a.length==1)
            {
                if(n<=1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            if(a[0]==0 && a[1]==0)
            {
                curr=1;
            }
        }
        if(a.length>2)
        {
            if(a[a.length-1]==0 && a[a.length-2]==0)
            {
                count=1;
            }
        }
        if(allZeros(a)) return (a.length+1)/2 >= n;
        while(i<a.length)
        {
            while(i<a.length)
            {
                if(a[i]==0)
                {
                    curr++;
                    i++;
                }
                else
                {
                    break;
                }
            }
            count+=(curr-1)/2;
            if(count>=n)
            {
                return true;
            }
            curr=0;
            i++;
        }
        return count>=n;
    }
}
