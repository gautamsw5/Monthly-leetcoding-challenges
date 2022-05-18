class Solution
{
    List<List<Integer>> adj;
    List<List<Integer>> ret;
    boolean[] vis;
    int[] lr;
    void dfs(int cur, int r, int prev)
    {
        vis[cur] = true;
        lr[cur] = r;
        for(int v : adj.get(cur))
        {
            if(v!=prev)
            {
                if(!vis[v])
                {
                    dfs(v, r+1, cur);
                }
                lr[cur] = Math.min(lr[cur], lr[v]);
                if(lr[v]>r)
                {
                    List<Integer> t = new ArrayList<>(); t.add(cur); t.add(v);
                    ret.add(t);
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con)
    {
        ret = new ArrayList<>();
        adj = new ArrayList<>();
        vis = new boolean[n];
        lr = new int[n];
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<Integer>());
            lr[i] = i;
        }
        for(int i=0; i<con.size(); i++)
        {
            adj.get(con.get(i).get(0)).add(con.get(i).get(1));
            adj.get(con.get(i).get(1)).add(con.get(i).get(0));
        }
        dfs(0, 0, -1);
        return ret;
    }
}
