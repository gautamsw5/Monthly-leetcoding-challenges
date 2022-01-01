# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def maxMin(self, root):
        if root:
            left = self.maxMin(root.left)
            right = self.maxMin(root.right)
            ret = [root.val, root.val]
            if root.left:
                self.ans = max(self.ans, abs(root.val - left[0]), abs(root.val - left[1]))
                ret[0] = max(ret[0], left[0])
                ret[1] = min(ret[1], left[1])
            if root.right:
                self.ans = max(self.ans, abs(root.val - right[0]), abs(root.val - right[1]))
                ret[0] = max(ret[0], right[0])
                ret[1] = min(ret[1], right[1])
            return ret
        
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        self.maxMin(root)
        return self.ans
