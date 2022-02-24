/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            new Comparator<ListNode>()
            {
                public int compare(ListNode a, ListNode b)
                {return a.val - b.val;}
            });
        ListNode headnew=null,tailnew;
        while(head!=null)
        {
            queue.add(head);
            head=head.next;
        }
        headnew=queue.poll();
        tailnew=headnew;
        int n=queue.size();
        while(n!=0)
        {
            tailnew.next=queue.poll();
            tailnew=tailnew.next;
            n--;
        }
        tailnew.next=null;
        return headnew;
    }
}
