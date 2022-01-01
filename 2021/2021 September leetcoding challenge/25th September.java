class Cell {
    int x, y, obs;
    Cell(){}
    Cell(int x, int y, int obs) {
        this.x = x;
        this.y = y;
        this.obs = obs;
    }
}

class Solution {
    
    private static int[][] adj = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        Integer[][] minObs = new Integer[n][m]; minObs[0][0] = 0;
        Queue<Cell> que = new LinkedList<>();
        que.add(new Cell(0, 0, 0));
        int d = 0;
        
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Cell cur = que.remove();
                if(cur.x == n-1 && cur.y == m-1) return d;
                for(int[] a : adj) {
                    int r = cur.x + a[0], c = cur.y + a[1];
                    if(r >= 0 && r < n && c >= 0 && c < m) {
                        int obs = cur.obs + grid[r][c];
                        if(obs <= k && (minObs[r][c] == null || obs < minObs[r][c])) {
                            minObs[r][c] = obs;
                            que.add(new Cell(r, c, obs));
                        }
                    }
                }
            }
            d++;
        }
        
        return -1;
    }
}
