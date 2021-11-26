class Solution {
    public int searchInsert(int[] arr, int x) {
        int l = 0, r = arr.length-1;
        if(x > arr[r]) return r+1;
        else if(x < arr[l]) return 0;
        while(l <= r) {
            int m = (l+r)/2;
            if(arr[m] >= x && (m==0 || arr[m-1] < x)) {
                return m;
            }
            else if(arr[m] > x) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return -1;
    }
}
