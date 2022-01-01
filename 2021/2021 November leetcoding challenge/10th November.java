class Solution {
    public int maxProfit(int[] arr)
    {
        int i=0,
        p=0;
        while(i<arr.length-1)
        {
            while(i<arr.length-1 && arr[i]>=arr[i+1])
            {
                i++;
            }
            p-=arr[i];
            while(i<arr.length-1 && arr[i]<=arr[i+1])
            {
                i++;
            }
            p+=arr[i];
        }
        return p;
    }
}
