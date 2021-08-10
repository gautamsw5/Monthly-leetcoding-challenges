import java.util.*;
class Solution
{
    int n;
    List<Integer>[] adj;
    Integer[] dp;
    int minPath(int s)
    {
        if(s==n)
            return 0;
        if(dp[s]!=null)
            return dp[s];
        int ans = Integer.MAX_VALUE;
        for(Integer v : adj[s])
            ans = Math.min(ans, 1+minPath(v));
        dp[s] = ans;
        return ans;
    }
    public int minCut(String S)
    {
        char[] s = S.toCharArray();
        n = s.length;
        adj = new List[n];
        dp = new Integer[n];
        for(int i=0; i<n; i++)
        {
            int l = i, r = i;
            while(l>=0 && r<n && s[l]==s[r])
            {
                if(adj[l]==null)
                    adj[l] = new ArrayList<Integer>();
                adj[l--].add(++r);
            }
            l = i;
            r = i+1;
            while(l>=0 && r<n && s[l]==s[r])
            {
                if(adj[l]==null)
                    adj[l] = new ArrayList<Integer>();
                adj[l--].add(++r);
            }
        }
        return minPath(0)-1;
    }
}