class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        TreeSet<Integer>[] indices = new TreeSet[102];   // Used treeset so that higher function can be used
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i = 0; i < 102; i++) {
            indices[i] = new TreeSet<Integer>();
        }
		
        for(int i = 0; i < temperatures.length; i++) {
            indices[temperatures[i]].add(i);                   // Add every index in its corresponding temperature
        }
		
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = temperatures[i]+1; j < 102; j++) {     // Check for all values greater than temperature[i] whether they occur after i or not and get the minimum such index
                Integer x = indices[j].higher(i);
                if(x != null) ans[i] = Math.min(ans[i], x);
            }
            if(ans[i] == Integer.MAX_VALUE) ans[i] = 0;  // Not found so 0
            else ans[i] -= i;      // Number of days to wait
        }
        return ans;
    }
}
