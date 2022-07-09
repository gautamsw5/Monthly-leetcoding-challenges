class Solution {
    public int maxResult(int[] arr, int k) {
        int ans = Integer.MIN_VALUE, n = arr.length, l = n-1, r = n-1;
        int[] dp = new int[n];
        dp[n-1] = arr[n-1];
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i = n-2; i >= 0; i--) {
            while(l > i) {
                freq.put(dp[l], freq.getOrDefault(dp[l], 0) + 1);
                if(!map.containsKey(dp[l])) map.put(dp[l], new LinkedList<Integer>());
                map.get(dp[l]).add(l);
                l--;
            }
            while(r - l > k) {
                if(freq.get(dp[r]) == 1) {
                    freq.remove(dp[r]);
                } else {
                    freq.put(dp[r], freq.get(dp[r]) - 1);
                }
                map.get(dp[r]).removeFirst();
                r--;
            }
            dp[i] = arr[i] + freq.lastKey();
        }
        return dp[0];
    }
}
