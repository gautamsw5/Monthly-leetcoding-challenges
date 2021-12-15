# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        arr = []
        while head != None:
            arr.append(head)
            head = head.next
            arr[-1].next = None
        arr.sort(key = lambda x : x.val)
        for i in range(len(arr)-1):
            arr[i].next = arr[i+1]
        return arr[0]
