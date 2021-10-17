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
    int count, x;
    Map<Integer, Integer> solve(TreeNode root) {
        if(root == null) return new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>(), left = solve(root.left), right = solve(root.right);
        for(int i : left.keySet()) {
            freq.put(i+root.val, freq.getOrDefault(i+root.val, 0) + left.getOrDefault(i, 0));
        }
        for(int i : right.keySet()) {
            freq.put(i+root.val, freq.getOrDefault(i+root.val, 0) + right.getOrDefault(i, 0));
        }
        freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
        count += freq.getOrDefault(x, 0);
        return freq;
    }
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        x = targetSum;
        solve(root);
        return count;
    }
}
