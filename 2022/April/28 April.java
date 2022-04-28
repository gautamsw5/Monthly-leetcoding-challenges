class Solution
{
    private boolean dfs(int[][] mat, int i, int j, int n, int m, int k, boolean[][] visited, int[][] neibs)
    {
        if(i==n-1 && j==m-1)
        {
            return true;
        }
        boolean ret = false;
        visited[i][j]=true;
        for(int[] x : neibs)
        {
            if(i+x[0]>=0 && i+x[0]<n && j+x[1]>=0 && j+x[1]<m && !visited[i+x[0]][j+x[1]] && Math.abs(mat[i][j]-mat[i+x[0]][j+x[1]])<=k)
            {
                ret = ret || dfs(mat,i+x[0],j+x[1],n,m,k,visited,neibs);
                if(ret)
                {
                    return ret;
                }
            }
        }
        return ret;
    }
    public int minimumEffortPath(int[][] mat)
    {
        int n=mat.length,
        m=mat[0].length;
        if(n==1)
        {
            int i=0,
            mx=0;
            for(i=0;i<m-1;i++)
            {
                if(Math.abs(mat[0][i]-mat[0][i+1])>mx)
                {
                    mx=Math.abs(mat[0][i]-mat[0][i+1]);
                }
            }
            return mx;
        }
        if(m==1)
        {
            int i=0,
            mx=0;
            for(i=0;i<n-1;i++)
            {
                if(Math.abs(mat[i][0]-mat[i+1][0])>mx)
                {
                    mx=Math.abs(mat[i][0]-mat[i+1][0]);
                }
            }
            return mx;
        }
        SortedSet<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i+1<n)
                {
                    set.add(Math.abs(mat[i][j]-mat[i+1][j]));
                }
                if(i>0)
                {
                    set.add(Math.abs(mat[i][j]-mat[i-1][j]));
                }
                if(j+1<m)
                {
                    set.add(Math.abs(mat[i][j]-mat[i][j+1]));
                }
                if(j>0)
                {
                    set.add(Math.abs(mat[i][j]-mat[i][j-1]));
                }
            }
        }
        int[] arr = new int[set.size()];
        int i=0;
        for(int x : set)
        {
            arr[i++]=x;
        }
        boolean[][] visited = new boolean[n][m];
        int[][] neibs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //System.out.println(dfs(mat,0,0,n,m,496302,visited,neibs));
        if(dfs(mat,0,0,n,m,0,visited,neibs))
        {
            return 0;
        }
        int l=0,
        r=arr.length-1;
        while(l<=r)
        {
            int k = (l+r)/2;
            visited = new boolean[n][m];
            boolean cur = dfs(mat,0,0,n,m,arr[k],visited,neibs);
            boolean prev = false;
            if(k>0)
            {
                visited = new boolean[n][m];
                prev = dfs(mat,0,0,n,m,arr[k-1],visited,neibs);
            }
            if(cur && !prev)
            {
                return arr[k];
            }
            else if(!cur)
            {
                l=k+1;
            }
            else
            {
                r=k-1;
            }
        }
        System.out.println("NF");
        return 0;
    }
}
