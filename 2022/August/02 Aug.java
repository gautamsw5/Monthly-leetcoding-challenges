class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = -1000000001, r = 1000000000;
        while(l <= r) {
            // find number of elements <= m if its k return m
            int m = (l+r)/2;

            // System.out.println("Check value: "+m+" left: "+l+" right: "+r);
            int less = 0;
            for(int i = 0; i < matrix.length; i++) {
                int low = 0, high = matrix[0].length;
                while(low <= high) {
                    int mid = (low+high)/2;
                    if(mid < matrix[i].length && matrix[i][mid] <= m) low = mid + 1;
                    else high = mid - 1;
                }

                // System.out.println("row: "+i+" less: "+low);
                less += low;
            }

            // System.out.println();
            if(less < k) l = m + 1;
            else r = m - 1;
        }
        return r+1;
    }
}
