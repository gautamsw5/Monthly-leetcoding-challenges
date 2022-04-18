# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root):
        if root and len(self.arr) < self.k:
            self.inorder(root.left)
            self.arr.append(root.val)
            self.inorder(root.right)
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.arr = []
        self.inorder(root)
        return self.arr[k-1]
