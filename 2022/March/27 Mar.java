class Solution {
    public int[] kWeakestRows(int[][] mat, int k)
    {
        int[] a = new int[k];
        int[] wt = new int[mat.length];
        int[] arr = new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            int l=0,r=mat[i].length-1,p=0;
            while(l<=r)
            {
                int m=l+(r-l)/2;
                if(mat[i][m]==1)
                {
                    l=m+1;
                }
                else
                {
                    r=m-1;
                }
                if(m+1<mat[i].length && mat[i][m]==1 && mat[i][m+1]==0)
                {
                    p=m+1;
                    //System.out.println(i+" -> "+p);
                    break;
                }
                else if(mat[i][m]==1 && m+1==mat[i].length)
                {
                    p=m+1;
                    //System.out.println(i+" -> "+p);
                    break;
                }
            }
            wt[i]=p;
            arr[i]=i;
        }
        for(int i=0;i<wt.length-1;i++)
        {
            for(int j=0;j<wt.length-i-1;j++)
            {
                if(wt[j]>wt[j+1])
                {
                    int t=wt[j];
                    int t1=arr[j];
                    wt[j]=wt[j+1];
                    arr[j]=arr[j+1];
                    wt[j+1]=t;
                    arr[j+1]=t1;
                }
                else if(wt[j]==wt[j+1] && arr[j]>arr[j+1])
                {
                    int t1=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t1;
                }
            }
        }
        for(int i=0;i<k;i++)
        {
            a[i]=arr[i];
        }
        return a;
    }
}
