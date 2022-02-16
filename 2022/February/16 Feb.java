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
    public ListNode swapPairs(ListNode head)
    {
        if(head==null ||head.next==null)
        {
            return head;
        }
        ListNode t=head,t1=head.next;
        while(t!=null && t1!=null)
        {
            int g=t.val;
            t.val=t1.val;
            t1.val=g;
            t=t.next.next;
            try
            {
                t1=t.next;
            }catch(Exception e){;}
        }
        return head;
    }
}
