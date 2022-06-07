class Solution {
    public void merge(int[] arr, int m, int[] b, int n)
    {
        if(b.length>0)
        {
            int[] a = new int[m];
            for(int i=0;i<m;i++)
            {
                a[i]=arr[i];
            }
            int i=0,j=0,z=0;
            while(i<m && j<n)
            {
                if(a[i]<b[j])
                {
                    arr[z++]=a[i++];
                }
                else
                {
                    arr[z++]=b[j++];
                }
            }
            while(i<m)arr[z++]=a[i++];
            while(j<n)arr[z++]=b[j++];
        }
    }
}
