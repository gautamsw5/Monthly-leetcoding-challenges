# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        que = [(root, None)]
        while len(que) > 0:
            c = 0
            par = None
            for i in range(len(que)):
                cur = que.pop(0)
                if cur[0].val == x or cur[0].val == y:
                    c += 1
                    if c == 2 and par != cur[1]:
                        return True
                    par = cur[1]
                if cur[0].left != None:
                    que.append((cur[0].left, cur))
                if cur[0].right != None:
                    que.append((cur[0].right, cur))
        return False
