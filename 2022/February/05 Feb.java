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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1==null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        ListNode l3;
        ListNode tail;
        if(l1.val<l2.val)
        {
            l3=l1;
            tail=l3;
            l1=l1.next;
        }
        else
        {
            l3=l2;
            tail=l3;
            l2=l2.next;
        }
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                tail.next=l1;
                tail=tail.next;
                l1=l1.next;
            }
            else
            {
                tail.next=l2;
                tail=tail.next;
                l2=l2.next;
            }
        }
        if(l1==null)
        {
            tail.next=l2;
        }
        else
        {
            tail.next=l1;
        }
        return l3;
    }
    public ListNode mergeKLists(ListNode[] a)
    {
        int i=0,n=a.length-1;
        if(n==-1)
        {
            return null;
        }
        if(n==0)
        {
            return a[0];
        }
        while(n>0)
        {
            i=0;
            while(i<n-i)
            {
                a[i]=mergeTwoLists(a[i],a[n-i]);
                i++;
            }
            n=n/2;
        }
        return a[0];
    }
}
