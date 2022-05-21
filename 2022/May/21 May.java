class Solution
{
    public int coinChange(int[] coins, int N)
    {
        if(N==0)
        {
            return 0;
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.sort(coins);
        if(N<coins[0])
        {
            return -1;
        }
        dp[0] = 1;
        for(int coin:coins)
        {
            if(coin<=N)
            {
                dp[coin] = 1;
            }
        }
        for(int coin:coins)
        {
            for(int i=coin; i<N+1; i++)
            {
                if(dp[i-coin]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[N]==Integer.MAX_VALUE?-1:dp[N];
    }
}
