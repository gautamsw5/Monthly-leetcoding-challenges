/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        while(head != null) {
            if(head.val == Integer.MAX_VALUE) return head;
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return null;
    }
}
