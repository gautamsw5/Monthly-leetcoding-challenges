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
    private int len(ListNode head) {
        int n = 0;
        while(head != null) {
            head = head.next;
            n++;
        }
        return n;
    }
    public ListNode middleNode(ListNode head) {
        int n = len(head);
        for(int i = 0; i < n / 2; i++) {
            head = head.next;
        }
        return head;
    }
}
