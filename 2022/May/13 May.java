/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root)
    {
        if(root!=null)
        {
            //List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Node> t = new ArrayList<Node>();
            root.next=null;
            //ans.add(t);
            Queue<Node> que = new LinkedList<>();
            Queue<Node> next = new LinkedList<>();
            que.add(root);
            while(que.size()>0)
            {
                while(que.size()>0)
                {
                    Node cur = que.remove();
                    if(cur.left!=null)
                    {
                        t.add(cur.left);
                        next.add(cur.left);
                    }
                    if(cur.right!=null)
                    {
                        t.add(cur.right);
                        next.add(cur.right);
                    }
                }
                que=next;
                next = new LinkedList<>();
                if(t.size()>0)
                {
                    //ans.add(t);
                    for(int i=0;i<t.size()-1;i++)
                    {
                        t.get(i).next=t.get(i+1);
                    }
                    t.get(t.size()-1).next=null;
                }
                t = new ArrayList<Node>();
            }
        }
        return root;
    }
}
