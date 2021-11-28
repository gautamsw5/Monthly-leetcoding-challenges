class Solution
{
    private List<List<Integer>> ans;
    private List<Integer> path;
    private int n;
    private void dfs(int[][] graph, int i)
    {
        int f=0;
        for(int x:graph[i])
        {
            path.add(x);
            dfs(graph,x);
            if(x==n-1)
            ans.add(new ArrayList(path));
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        n=graph.length;
        ans = new ArrayList<List<Integer>>();
        path = new ArrayList<Integer>();
        path.add(0);
        dfs(graph,0);
        return ans;
    }
}
