import java.util.*;
class Node
{
    List<Node> children;
    int val;
    Node(int val)
    {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
class Solution
{
    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<Node> que = new LinkedList<>();
        if(root != null)
            que.add(root);
        while(!que.isEmpty())
        {
            Queue<Node> next = new LinkedList<>();
            List<Integer> lev = new ArrayList<>();
            while(!que.isEmpty())
            {
                Node cur = que.remove();
                for(Node c : cur.children)
                    if(c != null)
                        next.add(c);
                lev.add(cur.val);
            }
            que = next;
            ans.add(lev);
        }
        return ans;
    }
}