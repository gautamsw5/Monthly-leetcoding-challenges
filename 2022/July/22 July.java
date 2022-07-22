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
    ListNode insertLast(ListNode tail, ListNode node) {
        if(tail == null) {
            node.next = null;
            return node;
        }
        tail.next = node;
        node.next = null;
        return node;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode less = null, lessTail = null, more = null, moreTail = null;
        while(head != null) {
            ListNode temp = head.next;
            if(head.val < x) {
                lessTail = insertLast(lessTail, head);
                if(less == null) less = lessTail;
            } else {
                moreTail = insertLast(moreTail, head);
                if(more == null) more = moreTail;
            }
            head = temp;
        }
        if(less != null) {
            head = less;
            lessTail.next = more;
        } else {
            head = more;
        }
        return head;
    }
}
