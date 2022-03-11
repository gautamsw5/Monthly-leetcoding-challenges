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
    private int len(ListNode h) {
        int n = 0;
        while(h != null) {
            n++;
            h = h.next;
        }
        return n;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = len(head);
        if(n < 2) return head;
        k = (n - (k % n)) % n;
        if(k == 0) return head;
        ListNode h = head;
        for(int i = 0; i < k; i++) {
            if(i == k-1) {
                ListNode tmp = h.next;
                h.next = null;
                h = tmp;
            }
            else
                h = h.next;
        }
        ListNode t = h;
        while(t.next != null) {
           t = t.next;
        }
        t.next = head;
        return h;
    }
}
