import java.util.*;
class Solution
{
    public int[] twoSum(int[] arr, int x)
    {
        int[][] xrr = new int[arr.length][2];   // xrr[i][0] = element, xrr[i][1] = original index in arr
        for(int i=0; i<arr.length; i++)
        {
            xrr[i][0] = arr[i];                 // Store element
            xrr[i][1] = i;                      // Store its index
        }
        Arrays.sort(xrr, (a,b)->a[0]-b[0]);   // Sort using comparator
        int l = 0, r = arr.length-1;
        while(l < r)
        {
            if(xrr[l][0]+xrr[r][0] < x)
                l++;
            else if(xrr[l][0]+xrr[r][0] == x)
                return new int[]{xrr[l][1], xrr[r][1]};
            else
                r--;
        }
        return new int[]{};
    }
}