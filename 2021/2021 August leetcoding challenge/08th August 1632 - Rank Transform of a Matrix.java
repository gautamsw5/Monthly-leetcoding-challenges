import java.util.*;
class Solution
{
    class Node
    {
        int val;
        List<int[]> cor;
        Node(int val, List<int[]> cor)
        {
            this.val = val;
            this.cor = cor;
        }
    }
    List<int[]> cor;
    void dfs(int[][] matrix, int n, int m, int i, int j, int val)
    {
        if(matrix[i][j] != val)
            return;
        matrix[i][j] = Integer.MAX_VALUE;
        cor.add(new int[]{i, j});
        for(int x = 0; x < n; x++)
            dfs(matrix, n, m, x, j, val);
        for(int y = 0; y < m; y++)
            dfs(matrix, n, m, i, y, val);
    }
    public int[][] matrixRankTransform(int[][] matrix)
    {
        int n = matrix.length, m = matrix[0].length, k = 0;
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(matrix[i][j] != Integer.MAX_VALUE)
                {
                    int val = matrix[i][j];
                    cor = new ArrayList<>();
                    dfs(matrix, n, m, i, j, val);
                    Node node = new Node(val, cor);
                    nodes.add(node);
                }
            }
        }
        Collections.sort(nodes, (a,b)->a.val-b.val);
        int[] maxRankRow = new int[n];
        int[] maxRankCol = new int[m];
        int[][] ans = matrix;
        for(Node node : nodes)
        {
            int rank = 0;
            for(int[] x : node.cor)
            {
                rank = Math.max(rank, maxRankRow[x[0]]);
                rank = Math.max(rank, maxRankCol[x[1]]);
            }
            rank++;
            for(int[] x : node.cor)
            {
                ans[x[0]][x[1]] = rank;
                maxRankRow[x[0]] = Math.max(maxRankRow[x[0]], rank);
                maxRankCol[x[1]] = Math.max(maxRankCol[x[1]], rank);
            }
        }
        return ans;
    }
}