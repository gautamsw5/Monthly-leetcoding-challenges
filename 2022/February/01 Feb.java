class Solution {
    public int maxProfit(int[] arr) {
        int mi = 0, ans = 0;
        for(int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, arr[i] - arr[mi]);
            if(arr[i] < arr[mi]) mi = i;
        }
        return ans;
    }
}
