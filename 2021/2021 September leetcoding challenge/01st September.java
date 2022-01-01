class Solution
{
    public int arrayNesting(int[] arr)
    {
        this.dp = new int[arr.length];
        this.arr = arr;
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
            if(dp[i] == 0)
            {
                this.vis = new HashSet<>();
                ans = Math.max(ans, dfs(i));
            }
        return ans;
    }
    private int dfs(int i)
    {
        if(vis.contains(i))
            return 0;
        vis.add(i);
        if(dp[i] != 0)
            return dp[i];
        dp[i] = 1 + dfs(arr[i]);
        return dp[i];
    }
    private int[] arr, dp;
    private Set<Integer> vis;
}
