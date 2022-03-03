class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int i = 1, ans = 0;
        while(i < arr.length) {
            int d = arr[i] - arr[i-1], c = 0;
            while(i < arr.length && arr[i] - arr[i-1] == d) {
                i++;
                c++;
            }
            ans += (c*(c-1))/2;
        }
        return ans;
    }
}
