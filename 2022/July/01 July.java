class Solution
{
    public int maximumUnits(int[][] arr, int t)
    {
        int ans=0;
        Arrays.sort(arr, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                if(a[1]<b[1])
                {
                    return 1;
                }
                else if(a[1]==b[1] && a[0]<b[0])
                {
                    return 1;
                }
                return -1;
            }
        });
        int i=0;
        while(t>0 && i<arr.length)
        {
            if(arr[i][0]>t)
            {
                ans+=t*arr[i][1];
                break;
            }
            t-=arr[i][0];
            ans+=arr[i][0]*arr[i][1];
            i++;
        }
        return ans;
    }
}
