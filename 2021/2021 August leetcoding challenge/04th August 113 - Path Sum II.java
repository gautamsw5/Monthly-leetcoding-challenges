import java.util.*;
class TreeNode
{
    int val;
    TreeNode left, right;
    TreeNode(int val)
    {
        this.val = val;
    }
}
class Solution
{
    List<Integer> cur;
    void solve(TreeNode root, int targetSum, List<List<Integer>> ans)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(targetSum == root.val)
            {
                cur.add(root.val);
                ans.add(new ArrayList<>(cur));
                cur.remove(cur.size()-1);
            }
            return;
        }
        cur.add(root.val);
        solve(root.left, targetSum - root.val, ans);
        solve(root.right, targetSum - root.val, ans);
        cur.remove(cur.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> ans = new ArrayList<>();
        cur = new ArrayList<>();
        solve(root, targetSum, ans);
        return ans;
    }
}