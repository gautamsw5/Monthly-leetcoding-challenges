/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution
{
    private Node ans,tail;
    private void fatten(Node head)
    {
        if(head!=null)
        {
            //System.out.print(head.val+" ");
            Node child = head.child, next = head.next;
            if(ans==null)
            {
                ans=head;
                tail=head;
                tail.child=null;
            }
            else
            {
                tail.next=head;
                tail.next.prev=tail;
                tail.child=null;
                tail=tail.next;
            }
            fatten(child);
            fatten(next);
        }
    }
    public Node flatten(Node head)
    {
        ans=null;
        fatten(head);
        return ans;
    }
}
