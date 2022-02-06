class Solution
{
public:
    int removeDuplicates(vector<int>& a)
    {
        int n=a.size();
        if(n<=2)
            return n;
        int j=1,f=0;
        int i,prev=a[0];
        for(i=1;i<n;i++)
        {
            if(a[i]!=prev)
            {
                a[j]=a[i];
                prev=a[i];
                f=0;
                j++;
            }
            else if(f==0)
            {
                a[j]=a[i];
                prev=a[i];
                j++;
                f=1;
            }
        }
        return j;
    }
};
