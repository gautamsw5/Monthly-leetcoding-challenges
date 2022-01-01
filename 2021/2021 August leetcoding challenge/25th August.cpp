class Solution {
public:
    bool judgeSquareSum(int c)
    {
        long i=0;
        if(c==0)
            return 1;
        while(i*i<c)
        {
            if((float)(int)sqrt(c-i*i)==sqrt(c-i*i))
                return true;
            i++;
        }
        return false;
    }
};
