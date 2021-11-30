class Solution
{
    private int[] getNextSmallerArr(int[] arr, int n)
    {
        int[] nextSmallerIdx = new int[n];
        List<List<Integer>> incr = new ArrayList<>();
        int i = 0;
        while(i < n)
        {
            List<Integer> t = new ArrayList<>();
            t.add(i);
            while(i+1 < n && arr[i] <= arr[i+1])
                t.add(++i);
            incr.add(t);
            i++;
        }
        for(i = 0; i < incr.size(); i++)
        {
            int k = i+1;
            for(int j = incr.get(i).size()-1; j >= 0; j--)
            {
                while(k < incr.size() && arr[incr.get(k).get(0)] >= arr[incr.get(i).get(j)])
                    k++;
                if(k == incr.size())
                    nextSmallerIdx[incr.get(i).get(j)] = n;
                else
                    nextSmallerIdx[incr.get(i).get(j)] = incr.get(k).get(0);
            }
        }
        // System.out.println(Arrays.toString(arr)+" "+incr+" "+Arrays.toString(nextSmallerIdx));
        return nextSmallerIdx;
    }
    private int[] getPrevSmallerArr(int[] arr, int n)
    {
        int[] prevSmallerIdx = new int[n];
        List<List<Integer>> incr = new ArrayList<>();
        int i = n-1;
        while(i >= 0)
        {
            List<Integer> t = new ArrayList<>();
            t.add(i);
            while(i > 0 && arr[i] <= arr[i-1])
                t.add(--i);
            incr.add(t);
            i--;
        }
        for(i = 0; i < incr.size(); i++)
        {
            int k = i+1;
            for(int j = incr.get(i).size()-1; j >= 0; j--)
            {
                while(k < incr.size() && arr[incr.get(k).get(0)] >= arr[incr.get(i).get(j)])
                    k++;
                if(k == incr.size())
                    prevSmallerIdx[incr.get(i).get(j)] = -1;
                else
                    prevSmallerIdx[incr.get(i).get(j)] = incr.get(k).get(0);
            }
        }
        // System.out.println(Arrays.toString(arr)+" "+incr+" "+Arrays.toString(prevSmallerIdx));
        return prevSmallerIdx;
    }
    private int largestRectangle(int[] arr, int n)
    {
        int[] nextSmallerIdx = getNextSmallerArr(arr, n);
        int[] prevSmallerIdx = getPrevSmallerArr(arr, n);
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, arr[i]*(nextSmallerIdx[i]-prevSmallerIdx[i]-1));
        return ans;
    }
    public int maximalRectangle(char[][] mat)
    {
        if(mat.length == 0 || mat[0].length == 0)
            return 0;
        int[][] histogram = new int[mat.length][mat[0].length]; // Create histogram like
        for(int j = 0; j < mat[0].length; j++)
        {
            int i = mat.length-1, c = 0;
            while(i >= 0)
            {
                if(mat[i][j]=='1')
                {
                    if(i+1 < mat.length && mat[i+1][j] == '1')
                        histogram[i][j] = histogram[i+1][j] + 1;
                    else
                        histogram[i][j] = 1;
                }
                i--;
            }
        }
        // for(int[] x : histogram)
        //     System.out.println(Arrays.toString(x));
        int ans = 0;
        for(int i = 0; i < mat.length; i++)
            // histogram[i][j] -> use largest rectangle in histogram algorithm
            ans = Math.max(ans, largestRectangle(histogram[i], histogram[i].length));
        return ans;
    }
}
