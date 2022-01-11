# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def solve(self, root):
        if root:
            if root.val:
                self.cur = (self.cur << 1) | 1
            else:
                self.cur = (self.cur << 1)
            self.solve(root.left)
            self.solve(root.right)
            if root.left == None and root.right == None:
                self.ans += self.cur
            self.cur = self.cur >> 1
    
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        self.cur = 0
        self.solve(root)
        return self.ans
