class Solution
{
    long maxProd, treeSum;
    long fill(TreeNode root)
    {
        if(root != null)
        {
            long left = fill(root.left), right = fill(root.right);
            maxProd = Math.max(maxProd, left * (treeSum - left));
            maxProd = Math.max(maxProd, right * (treeSum - right));
            return root.val + left + right;
        }
        return 0;
    }
    long sum(TreeNode root)
    {
        if(root != null)
            return root.val + sum(root.left) + sum(root.right);
        return 0;
    }
    public int maxProduct(TreeNode root)
    {
        maxProd = 0;
        treeSum = sum(root);
        fill(root);
        return (int)(maxProd % 1000000007);
    }
}
