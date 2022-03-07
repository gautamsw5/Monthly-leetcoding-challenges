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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;
        ListNode c = null, tc = null;
        while(a != null && b != null) {
            if(c == null) {
                if(a.val < b.val) {
                    c = a;
                    tc = a;
                    a = a.next;
                }
                else {
                    c = b;
                    tc = b;
                    b = b.next;
                }
            }
            else {
                if(a.val < b.val) {
                    tc.next = a;
                    tc = tc.next;
                    a = a.next;
                }
                else {
                    tc.next = b;
                    tc = tc.next;
                    b = b.next;
                }
            }
        }
        if(b != null) tc.next = b;
        else if(a != null) tc.next = a;
        return c;
    }
}
