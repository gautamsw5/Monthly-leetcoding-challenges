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
class Solution
{
    public ListNode swapNodes(ListNode head, int k)
    {
        ListNode ptr = head;
        ListNode left = head;
        ListNode right = head;
        int n=1;
        while(ptr!=null)
        {
            if(n==k)
            {
                left = ptr;
            }
            ptr=ptr.next;
            n++;
        }
        ptr = head;
        int i=0;
        while(ptr!=null)
        {
            if(i==n-k-1)
            {
                right = ptr;
                break;
            }
            ptr = ptr.next;
            i++;
        }
        //System.out.println(left.val+" "+right.val);
        i=left.val;
        left.val=right.val;
        right.val=i;
        return head;
    }
}
