class Solution {
    public int numberOfSteps (int n)
    {
        int c=1;
        while(n>1)
        {
            c=c+(n%2)+1;
            n=n/2;
        }
        return n==0?0:c;
    }
}
