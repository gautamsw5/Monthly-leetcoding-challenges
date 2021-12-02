# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
        
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        oddHead = ListNode()
        oddTail = oddHead
        evenHead = ListNode()
        evenTail = evenHead
        
        i = 1
        while head != None:
            if i & 1:
                oddTail.next = head
                oddTail = oddTail.next
                head = head.next
                oddTail.next = None
            else:
                evenTail.next = head
                evenTail = evenTail.next
                head = head.next
                evenTail.next = None
            i += 1
            
        oddTail.next = evenHead.next
        
        return oddHead.next
