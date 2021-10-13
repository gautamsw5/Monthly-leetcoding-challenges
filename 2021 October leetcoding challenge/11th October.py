# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def paths(self, root):
        if root == None:
            return 0
        root.depth = 1 + max(self.paths(root.left), self.paths(root.right))
        return root.depth
    def traverse(self, root):
        if root == None:
            return
        l, r = 0, 0
        if root.left != None:
            l = root.left.depth
        if root.right != None:
            r = root.right.depth
        self.ans = max(self.ans, l + r)
        self.traverse(root.left)
        self.traverse(root.right)
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        self.paths(root)
        self.traverse(root)
        return self.ans
