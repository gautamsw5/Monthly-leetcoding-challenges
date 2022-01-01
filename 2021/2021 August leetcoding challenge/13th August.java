import java.util.*;
class Solution
{
    public void setZeroes(int[][] matrix)
    {
        int n = matrix.length, m = matrix[0].length;
        boolean[] rowContainsZero = new boolean[n];
        boolean[] colContainsZero = new boolean[m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(matrix[i][j] == 0)
                {
                    rowContainsZero[i] = true;
                    colContainsZero[j] = true;
                }
        for(int i = 0; i < n; i++)
            if(rowContainsZero[i])
                for(int j = 0; j < m; j++)
                    matrix[i][j] = 0;
        for(int j = 0; j < m; j++)
            if(colContainsZero[j])
                for(int i = 0; i < n; i++)
                    matrix[i][j] = 0;
    }
}
