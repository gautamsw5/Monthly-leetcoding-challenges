class Solution {
    public int rangeBitwiseAnd(int m, int n)
    {
        if(m==n)
        {
            return m;
        }
        int ans = m++ & n--;
        while(m<=n)
        {
            ans = ans & m & n;
            if(ans==0)
            {
                return 0;
            }
            m++;
            n--;
        }
        return ans;
    }
}
