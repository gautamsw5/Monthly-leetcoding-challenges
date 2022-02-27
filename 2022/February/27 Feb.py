# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorder(self, root, x):
        if root:
            root.val = x
            self.preorder(root.left, 2*x)
            self.preorder(root.right, 2*x+1)
    
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        que = [root]
        self.preorder(root, 0)
        ans = 1
        while que:
            for i in range(len(que)):
                u = que.pop(0)
                if u.left != None: que.append(u.left)
                if u.right != None: que.append(u.right)
            if que:
                ans = max(ans, que[-1].val - que[0].val + 1)
        return ans
