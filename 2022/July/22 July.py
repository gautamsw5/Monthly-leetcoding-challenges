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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode newHead = head, newTail = head;
        for(int i = 1; i < left; i++) {
            newTail = head;
            head = head.next;
        }
        ListNode revHead = head, revTail = head;
        for(int i = left; i < right+1; i++) {
            ListNode temp = head.next;
            head.next = revHead;
            revHead = head;
            head = temp;
        }
        newTail.next = revHead;
        revTail.next = head;
        if(left == 1) return revHead;
        return newHead;
    }
}
