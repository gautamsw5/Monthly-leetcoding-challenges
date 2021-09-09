class Cell {
    int val, up, down, left, right;
    Cell(int val) {
        this.up = this.down = this.left = this.right = this.val = val;
    }
    int getPlusSize() {
        return Math.min(up, Math.min(down, Math.min(left, right)));
    }
}
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Cell[][] mat = new Cell[n][n];
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) mat[i][j] = new Cell(1);
        for(int[] mine: mines) mat[mine[0]][mine[1]] = new Cell(0);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j].val == 1) {
                    if(i > 0) mat[i][j].left += mat[i-1][j].left;
                    if(j > 0) mat[i][j].up += mat[i][j-1].up;
                }
            }
        }
        
        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(mat[i][j].val == 1) {
                    if(i+1 < n) mat[i][j].right += mat[i+1][j].right;
                    if(j+1 < n) mat[i][j].down += mat[i][j+1].down;
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++)
            ans = Math.max(ans, mat[i][j].getPlusSize());
        return ans;
    }
}
