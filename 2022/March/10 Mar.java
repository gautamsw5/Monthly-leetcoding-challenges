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
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int c = 0;
        ListNode head = new ListNode(), tail = head;
        while(a != null && b != null) {
            tail.next = new ListNode((a.val + b.val + c) % 10);
            tail = tail.next;
            if(a.val + b.val + c > 9) c = 1;
            else c = 0;
            a = a.next;
            b = b.next;
        }
        while(a != null) {
            tail.next = new ListNode((a.val + c) % 10);
            tail = tail.next;
            if(a.val + c > 9) c = 1;
            else c = 0;
            a = a.next;
        }
        while(b != null) {
            tail.next = new ListNode((b.val + c) % 10);
            tail = tail.next;
            if(b.val + c > 9) c = 1;
            else c = 0;
            b = b.next;
        }
        if(c == 1) tail.next = new ListNode(1);
        return head.next;
    }
}
