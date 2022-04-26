class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 0;
        int[][] edges = new int[n*(n-1)/2][3];
        int z = 0;
        for(int i = 0; i < n; i++)
        for(int j = i+1; j < n; j++) {
            edges[z][0] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            edges[z][1] = i;
            edges[z++][2] = j;
        }
        Set<Integer>[] uf = new Set[n];
        for(int i = 0; i < n; i++) { uf[i] = new HashSet<>(); uf[i].add(i); }
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        int cost = 0;
        for(int[] edge : edges) {
            int i = edge[1], j = edge[2];
            if(uf[i] != uf[j]) {
                cost += edge[0];
                uf[i].addAll(uf[j]);
                for(int k : uf[i]) uf[k] = uf[i];
            }
        }
        return cost;
    }
}
