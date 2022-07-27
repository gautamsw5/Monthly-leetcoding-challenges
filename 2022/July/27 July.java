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
    public TreeNode[] flatten(TreeNode root) {
        if(root != null) {
            if(root.left == null && root.right == null) return new TreeNode[]{root, root};
            TreeNode[] left = flatten(root.left);
            TreeNode[] right = flatten(root.right);
            if(root.left == null) return new TreeNode[]{root, right[1]};
            root.left = null;
            if(root.right == null) {
                root.right = left[0];
                return new TreeNode[]{root, left[1]};
            }
            left[1].right = right[0];
            root.right = left[0];
            return new TreeNode[]{root, right[1]};
        }
        return new TreeNode[]{root, root};
    }
}
