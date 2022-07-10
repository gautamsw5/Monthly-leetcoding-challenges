class Solution
{
    private int mincst(int[] cost, int[] dp, int pos)
    {
        if(pos==cost.length)
        {
            return 0;
        }
        if(pos==cost.length-1 || pos==cost.length-2)
        {
            return cost[pos];
        }
        int a=0,b=0;
        if(pos<cost.length)
        {
            if(dp[pos+1]!=-1)
            {
                a=cost[pos]+dp[pos+1];
            }
            else
            {
                a=cost[pos]+mincst(cost, dp, pos+1);
                dp[pos+1]=a-cost[pos];
            }
            if(dp[pos+2]!=-1)
            {
                b=cost[pos]+dp[pos+2];
            }
            else
            {
                b=cost[pos]+mincst(cost, dp, pos+2);
                dp[pos+2]=b-cost[pos];
            }
        }
        return Math.min(a,b);
    }
    public int minCostClimbingStairs(int[] cost)
    {
        int[] dp = new int[cost.length+3];
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=-1;
        }
        return Math.min(mincst(cost,dp,0),mincst(cost,dp,1));
    }
}
