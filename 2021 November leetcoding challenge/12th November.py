# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        while head != None and head.val == val:
            head = head.next
        h = head
        while h != None:
            if h.next != None and h.next.val == val:
                h.next = h.next.next
            else:
                h = h.next
        return head
