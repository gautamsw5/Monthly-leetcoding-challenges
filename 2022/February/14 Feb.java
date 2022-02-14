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
    public int maxDepth(TreeNode root) {
        int d = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            int t = q.size();
            while(t-- > 0) {
                TreeNode u = q.poll();
                if(u.left != null) q.add(u.left);
                if(u.right != null) q.add(u.right);
            }
            d++;
        }
        return d;
    }
}
