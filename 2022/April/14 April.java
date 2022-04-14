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
    private TreeNode ans=null;
    private void search(TreeNode root, int val)
    {
        if(root!=null)
        {
            if(root.val==val)
            {
                ans=root;
            }
            else if(root.val>val)
            {
                search(root.left,val);
            }
            else
            {
                search(root.right,val);
            }
        }
    }
    public TreeNode searchBST(TreeNode root, int val)
    {
        ans=null;
        search(root,val);
        return ans;
    }
}
