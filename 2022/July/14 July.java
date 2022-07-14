class Solution
{
    Map<Integer, Integer> inidx;
    TreeNode build(int[] pre, int[] in, int il, int ir, int pl, int pr)
    {
        if(il>ir)
            return null;
        if(il==ir)
            return new TreeNode(in[il]);
        int i = inidx.get(pre[pl]);
        TreeNode ret = new TreeNode(pre[pl]);
        ret.left = build(pre, in, il, i-1, pl+1, pl+i-il);
        ret.right = build(pre, in, i+1, ir, pl+i-il+1, pr);
        return ret;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        inidx = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            inidx.put(inorder[i] ,i);
        return build(preorder, inorder, 0, preorder.length-1, 0, preorder.length-1);
    }
}
