class Solution {
    public int maxEnvelopes(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]==b[0] ? (b[1]-a[1]) : (a[0]-b[0]);
            }
        });
        int[][] a =  new int[n][];
        a[0] = arr[0];
        int k = 1;
        for(int i = 1; i < n; i++) {
            int l = 0, r = k-1;
            while(l <= r) {
                int m = (l+r)/2;
                if(a[m][1] >= arr[i][1]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if(l == k) {
                a[k++] = arr[i];
                continue;
            } else {
                a[l] = arr[i];
            }
        }
        return k;
    }
}
