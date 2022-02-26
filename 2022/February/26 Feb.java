class Solution {
    int[][] graph, adjacencyMatrix;
    Integer[][] dp;
    int n;
    int shortestPathLength(int vis, int u) {
        if(vis == (1 << n) - 1) return 0;
        if(dp[vis][u] != null) return dp[vis][u];
        dp[vis][u] = 100000;
        for(int v : graph[u]) {
            if(adjacencyMatrix[u][v] < 3) {
                adjacencyMatrix[u][v]++;
                dp[vis][u] = Math.min(dp[vis][u], 1 + shortestPathLength(vis | (1 << u), v));
                adjacencyMatrix[u][v]--;
            }
        }
        return dp[vis][u];
    }
    public int shortestPathLength(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        if(n < 2) return 0;
        adjacencyMatrix = new int[n][n];
        dp = new Integer[1 << n][n];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, shortestPathLength(0, i));
        }
        return ans - 1;
    }
}
