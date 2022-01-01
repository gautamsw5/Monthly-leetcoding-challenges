class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int n = mat.length, m = mat[0].length, il = 0, jl = 0, ir = n - 1, jr = m - 1;
        while(ans.size() < m*n) {
            // First row
            if(ans.size() < m*n)
                for(int j = jl; j <= jr; j++)
                    ans.add(mat[il][j]);
            il++;
            // Last column
            if(ans.size() < m*n)
                for(int i = il; i <= ir; i++)
                    ans.add(mat[i][jr]);
            jr--;
            // Last row rev
            if(ans.size() < m*n)
                for(int j = jr; j >= jl; j--)
                    ans.add(mat[ir][j]);
            ir--;
            // First column rev
            if(ans.size() < m*n)
                for(int i = ir; i >= il; i--)
                    ans.add(mat[i][jl]);
            jl++;
        }
        return ans;
    }
}
