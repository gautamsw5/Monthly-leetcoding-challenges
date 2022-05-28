class Solution {
public:
    int missingNumber(vector<int>& n)
    {
        int a,s=0;
        if(n.size()%2==0)
        {
            a=n.size()/2;
            a=a*(n.size()+1);
        }
        else
        {
            a=(n.size()+1)/2;
            a=a*n.size();
        }
        for(int i=0;i<n.size();i++)
        {
            s=s+n[i];
        }
        //if(a-s)
        return a-s;
    }
};
