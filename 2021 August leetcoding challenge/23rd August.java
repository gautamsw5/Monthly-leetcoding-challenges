class Solution
{
    boolean find(TreeNode root, TreeNode node, int x)
    {
        if(root == null)
            return false;
        if(root.val == x && root != node)
            return true;
        if(root.val > x)
            return find(root.left, node, x);
        return find(root.right, node, x);
    }
    boolean findTarget(TreeNode node, TreeNode root, int k)
    {
        if(node != null)
        {
            if(find(root, node, k-node.val))
                return true;
            if(findTarget(node.left, root, k))
                return true;
            return findTarget(node.right, root, k);
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k)
    {
        return findTarget(root, root, k);
    }
}
