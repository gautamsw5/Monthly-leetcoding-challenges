class Solution
{
    public int goodNodes(TreeNode root)
    {
        ans = 0;
        preorder(root, Integer.MIN_VALUE);
        return ans;
    }
    
    void preorder(TreeNode root, int max)
    {
        if(root == null)
            return;
        max = Math.max(max, root.val);
        if(max == root.val)
            ans++;
        preorder(root.left, max);
        preorder(root.right, max);
    }
    
    int ans;
}
