class Solution
{
    private boolean ans;
    private int[] colors;
    private void bfs(int[][] graph, int src)
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        while(que.size()>0)
        {
            int v = que.remove();
            for(int u : graph[v])
            {
                if(colors[u]==colors[v])
                {
                    ans = false;
                }
                if(colors[u]==0)
                {
                    if(colors[v]==1)
                    {
                        colors[u]=2;
                    }
                    else
                    {
                        colors[u]=1;
                    }
                    que.add(u);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph)
    {
        ans = true;
        colors = new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(colors[i]==0)
            {
                colors[i]=1;
                bfs(graph,i);
            }
        }
        //System.out.println(Arrays.toString(colors));
        return ans;
    }
}
