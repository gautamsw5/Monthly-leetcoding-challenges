class Solution {
    public int minOperations(int[] arr, int x) {
        /*
        n - (Largest Subarray with sum = sum(arr) - x)
        */
        int n = arr.length, ans = -1, l = 0, r = 0;
        
        long sum = 0L, s = 0L;
        for(int i = 0; i < n; i++) sum += arr[i];
        sum -= x;
        
        while(true) {
            byte f = 0;
            while(r < n && s < sum) {
                s += arr[r++];
                f = 1;
            }
            if(s == sum && (ans == -1 || ans > n-(r-l))) ans = n-(r-l);
            while(s >= sum && l < r) {
                s -= arr[l++];
                if(s == sum && (ans == -1 || ans > n-(r-l))) ans = n-(r-l);
                f = 1;
                if(l > r) {
                    s = 0L;
                    r = l;
                    break;
                }
            }
            if(f == 0) break;
        }
        return ans;
    }
}
