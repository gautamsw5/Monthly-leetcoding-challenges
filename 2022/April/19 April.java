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
    List<TreeNode> arr;
    boolean contains(TreeNode root, int v)
    {
        if(root==null)
            return false;
        return root.val==v || contains(root.left, v) || contains(root.right, v);
    }
    void fill(TreeNode root)
    {
        if(root != null)
        {
            fill(root.left);
            arr.add(root);
            fill(root.right);
        }
    }
    public void recoverTree(TreeNode root)
    {
        arr = new ArrayList<>();
        fill(root);
        int i = -1, j = -1, k = 0;
        while(arr.get(k).val < arr.get(k+1).val)
            k++;
        i = k;
        //System.out.println(i);
        k++;
        while(k+1<arr.size() && arr.get(k).val < arr.get(k+1).val)
            k++;
        if(k==arr.size()-1)
            j = i+1;
        else
            j = ++k;
        if(i!=-1 && j!=-1)
        {
            //System.out.println(arr.get(i).val + " " + arr.get(j).val);
            int t = arr.get(i).val;
            arr.get(i).val = arr.get(j).val;
            arr.get(j).val = t;
        }
    }
}
