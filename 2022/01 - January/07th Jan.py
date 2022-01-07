# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def __init__(self, head: Optional[ListNode]):
        self.list = []
        while head != None:
            self.list.append(head.val)
            head = head.next
        self.n = len(self.list)

    def getRandom(self) -> int:
        return self.list[random.randint(0, self.n-1)]


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()
