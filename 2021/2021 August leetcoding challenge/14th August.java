import java.util.*;
class Solution
{
    int[] boxes;
    int[][][] dp;
    int solve(int p, int s, int e)
    {
        if(s > e)
            return 0;
        if(dp[p][s][e] != 0)
            return dp[p][s][e];
        dp[p][s][e] = p*p + solve(1, s+1, e);
        for(int i = s+1; i <= e; i++)
        {
            if(boxes[i] == boxes[s])
                dp[p][s][e] = Math.max(dp[p][s][e], solve(1, s+1, i-1) + solve(p+1, i, e));
        }
        return dp[p][s][e];
    }
    public int removeBoxes(int[] boxes)
    {
        this.boxes = boxes;
        this.dp = new int[boxes.length+1][boxes.length][boxes.length];
        return solve(1, 0, boxes.length-1);
    }
}
