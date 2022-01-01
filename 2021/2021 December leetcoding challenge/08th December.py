# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def getSubTreeSum(self, root : Optional[TreeNode]) -> int:
        if root:
            left = self.getSubTreeSum(root.left)
            right = self.getSubTreeSum(root.right)
            self.ans += abs(left - right)
            return root.val + left + right
        return 0
        
    def findTilt(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        self.getSubTreeSum(root)
        return self.ans
