class Solution {
public:
    int addDigits(int n)
    {
        int s;
        while(n>9)
        {
            s=0;
            while(n>0)
            {
                s=s+n%10;
                n=n/10;
            }
            n=s;
        }
        return n;
    }
};
