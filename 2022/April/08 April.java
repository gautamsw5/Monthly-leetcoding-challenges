class KthLargest
{
    private int[] arr = new int[1];
    private int k=0;
    public KthLargest(int K, int[] nums)
    {
        arr = new int[K];
        k = K;
        Arrays.sort(nums);
        int m=1;
        for(int i=K-1;i>=0;i--)
        {
            try
            {
                arr[i]=nums[nums.length-m];
                m++;
            }
            catch(Exception e)
            {
                arr[i]=Integer.MIN_VALUE;
            }
        }
    }
    public int add(int val)
    {
        if(val>arr[arr.length-k])
        {
            int c=0;
            while(c<arr.length-1)
            {
                if(arr[c+1]>=val)
                {
                    break;
                }
                c++;
            }
            for(int i=0;i<c;i++)
            {
                arr[i]=arr[i+1];
            }
            arr[c]=val;
        }
        return arr[arr.length-k];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
