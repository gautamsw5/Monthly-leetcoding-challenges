class Solution {
    public int singleNumber(int[] a)
    {
        int r=0;
        for(int i:a)
        {
            r=r^i;
        }
        return r;
    }
}
