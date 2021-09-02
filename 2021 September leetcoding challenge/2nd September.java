class Solution {
    
    public List<TreeNode> generateTrees(int n) {
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
            arr.add(i+1);
        return solve(arr);  
    }
    
    private List<TreeNode> solve(List<Integer> arr) {
        
        if(arr.size() == 0) {
            List<TreeNode> t = new ArrayList<>();
            t.add(null);
            return t;
        }
        
        if(arr.size() == 1) {
            List<TreeNode> t = new ArrayList<>();
            t.add(new TreeNode(arr.get(0)));
            return t;
        }
        
        List<TreeNode> ret = new ArrayList<>();
        for(int i : arr) {
            
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            
            for(int j : arr) {
                if(j < i)
                    left.add(j);
                else if(j > i)
                    right.add(j);
            }
            
            for(TreeNode lef : solve(left)) {
                
                for(TreeNode rit : solve(right)) {
                    
                    TreeNode root = new TreeNode(i);
                    root.left = lef;
                    root.right = rit;
                    ret.add(root);
                }
            }
        }
        
        return ret;
        
    }
}
