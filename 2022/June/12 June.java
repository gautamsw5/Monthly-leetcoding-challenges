class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0, n = arr.length;
        int ans = 0, s = 0;
        while(l < n) {
            while(r < n && !set.contains(arr[r])) {
                s += arr[r];
                set.add(arr[r++]);
            }
            ans = Math.max(ans, s);
            s -= arr[l];
            set.remove(arr[l++]);
            if(l > r) {
                r = l;
                s = 0;
            }
        }
        return ans;
    }
}
