class Solution
{
    public Node connect(Node root)
    {
        if(root==null)
            return root;
        List<Node> que = new ArrayList<>();
        if(root!=null)
            que.add(root);
        int d = 0, c = 0;
        boolean f = true;
        while(f)
        {
            Node prev = null;
            for(int i=0; i< 1<<d; i++)
            {
                Node cur = que.get(c++);
                if(prev!=null)
                    prev.next = cur;
                if(cur.left==null)
                {
                    f=false;
                }
                que.add(cur.left);
                que.add(cur.right);
                prev = cur;
            }
            d++;
        }
        return root;
    }
}
