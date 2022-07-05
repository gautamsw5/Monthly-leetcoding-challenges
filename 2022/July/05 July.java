class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int i = 0, ans = 0, c = 0, n = arr.length;
        while(i < n) {
            i++;
            c = 1;
            while(i < n && arr[i] <= arr[i-1]+1) {
                if(arr[i] == arr[i-1]+1) c++;
                i++;
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
