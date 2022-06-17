# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# 0 -> parent camera
# 1 -> self camera
# 2 -> child camera
class Solution:
    def fill(self, root):
        if root:
            self.fill(root.left)
            self.fill(root.right)
            root.dp = [None]*3
            
    def solve(self, root, x):
        if root:
            if root.dp[x] != None:
                return root.dp[x]
            if x == 0:
                root.dp[x] = min(1 + self.solve(root.left, 0) + self.solve(root.right, 0),
                                min(self.solve(root.left, 1), self.solve(root.left, 2)) + min(self.solve(root.right, 1), self.solve(root.right, 2)))
            elif x == 1:
                root.dp[x] = 1 + min(self.solve(root.left, 0), self.solve(root.left, 1), self.solve(root.left, 2)) + min(self.solve(root.right, 0), self.solve(root.right, 1), self.solve(root.right, 2))
            else:
                root.dp[x] = 1000000
                if root.left != None:
                    root.dp[x] = min(root.dp[x], self.solve(root.left, 1) + min(self.solve(root.right, 1), self.solve(root.right, 2)))
                if root.right != None:
                    root.dp[x] = min(root.dp[x], self.solve(root.right, 1) + min(self.solve(root.left, 1), self.solve(root.left, 2)))
            return root.dp[x]
        elif x == 2:
            return 10000000
        else:
            return 0
    
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        self.fill(root)
        return min(self.solve(root, 1), self.solve(root, 2))
