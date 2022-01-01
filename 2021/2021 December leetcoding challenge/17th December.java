class Solution {
    public int maximalSquare(char[][] mat) {
        int ans = 0, n = mat.length, m = mat[0].length;
        int[][] arr = new int[n][m];
        for(int j = 0; j < m; j++) {
            if(mat[0][j] == '1') arr[0][j] = 1;
            for(int i = 1; i < n; i++) {
                if(mat[i][j] == '1') arr[i][j] += arr[i-1][j] + 1;
            }
        }
        for(int i = 0; i < n; i++) {
            int j = 0;
            while(j < m) {
                while(j < m && arr[i][j] == 0) j++;
                TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
                int l = j, r = j-1;
                while(j < m && arr[i][j] != 0) {
                    if(!map.containsKey(arr[i][j])) {
                        map.put(arr[i][j], new TreeSet<>());
                    }
                    map.get(arr[i][j]).add(j);
                    r++;
                    j++;
                }
                while(map.size() > 0) {
                    TreeSet<Integer> indices = map.get(map.firstKey());
                    while(indices.size() > 0) {
                        ans = Math.max(ans, Math.min(map.firstKey(), r-l+1));
                        int a = indices.first(), b = indices.last();
                        if(a-l < r-b) {
                            while(l <= a) {
                                map.get(arr[i][l]).remove(l);
                                if(map.get(arr[i][l]).size() == 0) map.remove(arr[i][l]);
                                l++;
                            }
                        }
                        else {
                            while(r >= b) {
                                map.get(arr[i][r]).remove(r);
                                if(map.get(arr[i][r]).size() == 0) map.remove(arr[i][r]);
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return ans*ans;
    }
}
