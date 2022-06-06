/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int len(ListNode h) {
        int n = 0;
        while(h != null) {
            h = h.next;
            n++;
        }
        return n;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = len(headA), m = len(headB);
        while(n > m) {
            headA = headA.next;
            n--;
        }
        while(n < m) {
            headB = headB.next;
            m--;
        }
        while(headA != null && headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
