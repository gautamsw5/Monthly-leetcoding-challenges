# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def count(self, head):
        n = 0
        while head != None:
            head = head.next
            n += 1
        return n
            
    def reorderList(self, head: Optional[ListNode]) -> None:
        n = self.count(head)
        left, right, leftTail, rightTail = None, None, None, None
        # Insert at end till ceil(n/2) nodes
        for i in range((n+n%2)//2):
            if left == None:
                left = head
                leftTail = left
            else:
                leftTail.next = head
                leftTail = leftTail.next
            head = head.next
            leftTail.next = None
        # Insert at begin
        for i in range((n+n%2)//2, n):
            if right == None:
                right = head
                rightTail = right
                head = head.next
                rightTail.next = None
            else:
                t = head.next
                head.next = right
                right = head
                head = t
        # Now alternate merge left and right
        while right != None:
            t = left.next
            left.next = right
            right = right.next
            left.next.next = t
            tail = left
            left = t
