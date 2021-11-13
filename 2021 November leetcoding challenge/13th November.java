class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        TreeSet<Integer>[] indices = new TreeSet[102];
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i = 0; i < 102; i++) {
            indices[i] = new TreeSet<Integer>();
        }
        for(int i = 0; i < temperatures.length; i++) {
            indices[temperatures[i]].add(i);
        }
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = temperatures[i]+1; j < 102; j++) {
                Integer x = indices[j].higher(i);
                if(x != null) ans[i] = Math.min(ans[i], x);
            }
            if(ans[i] == Integer.MAX_VALUE) ans[i] = 0;
            else ans[i] -= i;
        }
        return ans;
    }
}
