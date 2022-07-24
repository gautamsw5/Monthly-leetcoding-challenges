class Solution {
    public boolean searchMatrix(int[][] matrix, int x) {
        int l=0,
        i=-1,
        r=matrix.length-1;
        while(l <= r)
        {
            int mid = l + (r - l) / 2;
            if(matrix[mid][0] <= x && matrix[mid][matrix[mid].length-1]>=x)
            {
                i=mid;
                break;
            }
            if (matrix[mid][matrix[mid].length-1] < x)
            {
                l = mid + 1;
            }
            else if (matrix[mid][0] > x)
            {
                r = mid - 1;
            }
        }
        if(i>-1)
        {
            int j=i;
            while(j<matrix.length && matrix[j][0] <= x && matrix[j][matrix[j].length-1]>=x)
            {
                int L=0,
                R=matrix[j].length-1;
                while(L <= R)
                {
                    int M = L + (R - L) / 2;
                    if(matrix[j][M] == x)
                    {
                        return true;
                    }
                    else if (matrix[j][M] < x)
                    {
                        L = M + 1;
                    }
                    else
                    {
                        R = M - 1;
                    }
                }
                j++;
            }
            j=i;
            while(j>-1 && matrix[j][0] <= x && matrix[j][matrix[j].length-1]>=x)
            {
                int L=0,
                R=matrix[j].length-1;
                while(L <= R)
                {
                    int M = L + (R - L) / 2;
                    if(matrix[j][M] == x)
                    {
                        return true;
                    }
                    else if (matrix[j][M] < x)
                    {
                        L = M + 1;
                    }
                    else
                    {
                        R = M - 1;
                    }
                }
                j--;
            }
        }
        return false;
    }
}
