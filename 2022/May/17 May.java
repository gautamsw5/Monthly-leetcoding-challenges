/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution
{
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target)
    {
        if(original==target)
        {
            return cloned;
        }
        if(original!=null)
        {
            TreeNode t=getTargetCopy(original.left,cloned.left,target);
            if(t!=null)
            {
                return t;
            }
            t=getTargetCopy(original.right,cloned.right,target);
            if(t!=null)
            {
                return t;
            }
        }
        return null;
    }
}
