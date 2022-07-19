class Solution {
    public List<List<Integer>> generate(int n)
    {
        if(n==0)
        {
            return Collections.emptyList();
        }
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        List<Integer>first=new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        if(n==1)
        {
            return result;
        }
        List<Integer>second=new ArrayList<Integer>();
        second.add(1);
        second.add(1);
        result.add(second);
        if(n==2)
        {
            return result;
        }
        List<Integer>third=new ArrayList<Integer>();
        third.add(1);
        third.add(2);
        third.add(1);
        result.add(third);
        //vector<vector<int>>result{{1},{1,1},{1,2,1}};
        //result.add({1,2,1});
        for(int i=4;i<n+1;i++)
        {
            List<Integer>curr=new ArrayList<Integer>();
            for(int k=0;k<i;k++)curr.add(k,0);
            int a=1,j=0;
            while(j<(i+1)/2)
            {
                curr.set(j,a);//curr[j]=a;
                curr.set(i-j-1,a);//curr[i-j-1]=a;
                j++;
                a=result.get(i-2).get(j)+result.get(i-2).get(j-1);//result[i-2][j]+result[i-2][j-1];
            }
            result.add(curr);
        }
        return result;
    }
}
