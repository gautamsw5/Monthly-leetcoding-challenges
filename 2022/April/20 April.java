/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator
{
    private List<TreeNode> list;
    private int i;
    private void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }
    public BSTIterator(TreeNode root)
    {
        list = new ArrayList<TreeNode>();
        inorder(root);
        i=0;
    }
    public int next()
    {
        return list.get(i++).val;
    }
    public boolean hasNext()
    {
        return i<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
