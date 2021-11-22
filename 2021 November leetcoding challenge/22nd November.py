class Solution
{
    public TreeNode deleteNode(TreeNode root, int v)
    {
        if(root!=null)
        {
            if(root.val == v)
            {
                if(root.left==null)
                    return root.right;
                else if(root.right==null)
                    return root.left;
                TreeNode l = root.left, t = root.left;
                while(t.right != null)
                    t = t.right;
                t.right = root.right;
                return l;
            }
            else if(root.val > v)
            {
                root.left = deleteNode(root.left, v);
            }
            else
            {
                root.right = deleteNode(root.right, v);
            }
        }
        return root;
    }
}
