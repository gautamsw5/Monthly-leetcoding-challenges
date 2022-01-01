# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def build(self, pl, pr, il, ir):
        if pl > pr:
            return None
        root = TreeNode(self.pre[pl])
        inidx = self.idx[self.pre[pl]]
        root.left = self.build(pl+1, pl+inidx-il, il, inidx-1)
        root.right = self.build(pl+inidx-il+1, pr, inidx+1, ir)
        return root
    def bstFromPreorder(self, pre: List[int]) -> Optional[TreeNode]:
        self.ino = sorted(pre)
        self.idx = {}
        self.pre = pre
        self.n = len(self.ino)
        for i in range(self.n):
            self.idx[self.ino[i]] = i
        return self.build(0, self.n-1, 0, self.n-1)
