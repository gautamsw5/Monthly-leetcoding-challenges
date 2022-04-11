class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k)
    {
        vector<int>oper;
        vector<vector<int>>ans;
        for(vector<int>i:grid)
        {
            oper.insert(oper.end(), i.begin(), i.end());
        }
        if(k>grid.size()*grid[0].size())
        {
            k=k%(grid.size()*grid[0].size());
        }
        for(int i=0;i<k;i++)
        {
            oper.insert(oper.begin()+i,oper[oper.size()-k+i]);
        }
        int n=grid[0].size();
        oper.erase(oper.end()-k, oper.end());
        for(int i=0;i<grid.size();i++)
        {
            vector<int>curr;
            curr.assign(oper.begin()+i*n,oper.begin()+i*n+n);
            ans.push_back(curr);
        }
        return ans;
    }
};
