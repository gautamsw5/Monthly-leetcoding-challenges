public class Node
{
    public int i;
    public int j;
    public List<Node> adj;
    public Node(int x, int y)
    {
        this.i=x;
        this.j=y;
        this.adj = new ArrayList<>();
    }
    public void add(Node n)
    {
        this.adj.add(n);
    }
}
class Solution
{
    public int ans;
    public void print(List<Node> path)
    {
        for(Node n: path)
        {
            System.out.print("("+n.i+","+n.j+") -> ");
        }
        System.out.println();
    }
    public void printpaths(Node u, Node d, boolean[][] visited, List<Node> path, int N)
    {
        if(u==d)
        {
            if(path.size()==N)
            {
                ans++;
            }
            //print(path);
            return;
        }
        visited[u.i][u.j] = true;
        for(Node x : u.adj)
        {
            if(!visited[x.i][x.j])
            {
                path.add(x);
                printpaths(x,d,visited,path,N);
                path.remove(x);
            }
        }
        visited[u.i][u.j] = false;
    }
    public int uniquePathsIII(int[][] grid)
    {
        int n = grid.length,
        m = grid[0].length;
        Node[][] graph = new Node[n][m];
        Node start = null, end = null;
        ans = 0;
        int N = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=-1)
                {
                    graph[i][j] = new Node(i,j);
                    N++;
                }
                if(grid[i][j]==1)
                {
                    start = graph[i][j];
                }
                else if(grid[i][j]==2)
                {
                    end = graph[i][j];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=-1)
                {
                    if(i>0 && grid[i-1][j]!=-1)
                    {
                        graph[i][j].add(graph[i-1][j]);
                    }
                    if(j>0 && grid[i][j-1]!=-1)
                    {
                        graph[i][j].add(graph[i][j-1]);
                    }
                    if(i<n-1 && grid[i+1][j]!=-1)
                    {
                        graph[i][j].add(graph[i+1][j]);
                    }
                    if(j<m-1 && grid[i][j+1]!=-1)
                    {
                        graph[i][j].add(graph[i][j+1]);
                    }
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        List<Node> paths = new ArrayList<>();
        paths.add(start);
        printpaths(start, end, visited, paths,N);
        return ans;
    }
}
