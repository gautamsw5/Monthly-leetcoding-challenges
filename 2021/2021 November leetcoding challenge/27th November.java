class Solution {
    public int[] productExceptSelf(int[] arr)
    {
        int p=1;
        int zi = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                zi++;
            }
            else
            {
                p=p*arr[i];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0 && zi==0)
            {
                arr[i]=p/arr[i];
            }
            else if(arr[i]==0 && zi==1)
            {
                arr[i]=p;
            }
            else
            {
                arr[i]=0;
            }
        }
        return arr;
    }
}
