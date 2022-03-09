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
    public ListNode deleteDuplicates(ListNode head)
    {
        int f=0;
        while(head!=null && head.next!=null && head.val==head.next.val)
        {
            head=head.next;
            f=1;
        }
        if(f==1)
        {
            head=deleteDuplicates(head.next);
            f=0;
        }
        ListNode temp=head;
        while(temp!=null)// && temp.next!=null)
        {
            f=0;
            while(temp.next!=null && temp.next.next!=null && temp.next.val==temp.next.next.val)
            {
                temp.next=temp.next.next;
                f=1;
            }
            if(f==1 && temp.next!=null)
            {
                temp.next=temp.next.next;
            }
            else
            {
                temp=temp.next;
            }
        }
        return head;
    }
}
