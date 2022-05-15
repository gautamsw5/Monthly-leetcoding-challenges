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
    private int t1,ans,s;
    private void paths(TreeNode root)
    {
        if(root!=null)
        {
            t1++;
            paths(root.left);
            paths(root.right);
            if(root.left==null && root.right==null)
            {
                if(t1>ans)
                {
                    ans=t1;
                }
            }
            t1--;
        }
    }
    private void paths2(TreeNode root)
    {
        if(root!=null)
        {
            t1++;
            paths2(root.left);
            paths2(root.right);
            if(root.left==null && root.right==null)
            {
                if(t1==ans)
                {
                    s+=root.val;
                }
            }
            t1--;
        }
    }
    public int deepestLeavesSum(TreeNode root)
    {
        s=0;
        t1=0;
        ans=0;
        paths(root);
        t1=0;
        paths2(root);
        return s;
    }
}
