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
class Solution {
    private int sum=0;
    private Set<TreeNode> set;
    private void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        TreeNode t=root;
        int f=0;
        while(t.left!=null)
        {
            f=1;
            t=t.left;
        }
        if(!set.contains(t) && f==1 && t.right==null)
        {
            sum+=t.val;
            set.add(t);
        }
        inorder(root.right);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        set= new HashSet<TreeNode>();
        inorder(root);
        return sum;
    }
}
