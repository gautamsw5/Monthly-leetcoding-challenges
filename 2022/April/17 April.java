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
class Solution
{
    private TreeNode ans=null,tail=null;
    private void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            if(ans==null)
            {
                ans=new TreeNode(root.val);
                tail=ans;
            }
            else
            {
                tail.right=new TreeNode(root.val);
                tail=tail.right;
            }
            inorder(root.right);
        }
    }
    public TreeNode increasingBST(TreeNode root)
    {
        ans=null;
        tail=null;
        inorder(root);
        return ans;
    }
}
