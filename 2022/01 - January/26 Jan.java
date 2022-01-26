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
    private List<Integer> l1,l2;
    private void inorder(TreeNode root, List<Integer> l)
    {
        if(root!=null)
        {
            inorder(root.left,l);
            l.add(root.val);
            inorder(root.right,l);
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2)
    {
        List<Integer> ans = new ArrayList<Integer>();
        l1 = new ArrayList<Integer>();
        l2 = new ArrayList<Integer>();
        inorder(root1,l1);
        inorder(root2,l2);
        int i=0,j=0;
        while(i<l1.size() && j<l2.size())
        {
            if(l1.get(i)<l2.get(j))
            {
                ans.add(l1.get(i++));
            }
            else
            {
                ans.add(l2.get(j++));
            }
        }
        while(i<l1.size())
        {
            ans.add(l1.get(i++));            
        }
        while(j<l2.size())
        {
            ans.add(l2.get(j++));            
        }
        return ans;
    }
}
