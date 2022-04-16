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
    private List<Integer> list;
    private int i;
    private void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
    private void inorder2(TreeNode root)
    {
        if(root!=null)
        {
            inorder2(root.left);
            root.val=list.get(i++);
            inorder2(root.right);
        }
    }
    public TreeNode convertBST(TreeNode root)
    {
        list = new ArrayList<Integer>();
        inorder(root);
        for(int i=list.size()-2;i>=0;i--)
        {
            list.set(i,list.get(i)+list.get(i+1));
        }
        i=0;
        inorder2(root);
        return root;
    }
}
