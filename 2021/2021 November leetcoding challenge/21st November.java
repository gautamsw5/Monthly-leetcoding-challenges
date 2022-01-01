class Solution
{
    Map<Integer, Integer> inidx;
    int[] inord, postord;
    TreeNode build(int l, int r, int pl, int pr)
    {
        if(l > r)
            return null;
        if(l==r)
            return new TreeNode(inord[l]);
        int idx = inidx.get(postord[pr]);
        TreeNode ret = new TreeNode(inord[idx]);
        ret.left = build(l, idx-1, pl, pl+idx-l-1);
        ret.right = build(idx+1, r, pl+idx-l, pr-1);
        return ret;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        inidx = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            inidx.put(inorder[i], i);
        inord = inorder;
        postord = postorder;
        return build(0, inorder.length-1, 0, inorder.length-1);
    }
}
