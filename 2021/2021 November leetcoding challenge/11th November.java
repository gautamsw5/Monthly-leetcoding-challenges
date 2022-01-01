class Solution {
    public int minStartValue(int[] arr)
    {
        int s=0,ans=0;
        for(int i:arr)
        {
            s=s+i;
            if(s<=0)
            {
                ans+=1-s;
                s=1;
            }
        }
        if(ans==0)
        {
            return 1;
        }
        return ans;
    }
}
