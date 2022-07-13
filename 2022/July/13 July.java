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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        if(root==null)
        {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> t = new ArrayList<Integer>();
        t.add(root.val);
        ans.add(t);
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        que.add(root);
        t = new ArrayList<Integer>();
        while(que.size()>0)
        {
            while(que.size()>0)
            {
                TreeNode cur = que.remove();
                if(cur.left!=null)
                {
                    t.add(cur.left.val);
                    next.add(cur.left);
                }
                if(cur.right!=null)
                {
                    t.add(cur.right.val);
                    next.add(cur.right);
                }
            }
            que=next;
            next = new LinkedList<>();
            if(t.size()>0)
            {
                ans.add(t);
            }
            t = new ArrayList<Integer>();
        }
        return ans;
    }
}
