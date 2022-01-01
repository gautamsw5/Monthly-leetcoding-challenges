class Solution:
    def solve(self, root : TreeNode, parRobbed : int):
        if root == None:
            return 0
        if root.dp[parRobbed] != None:
            return root.dp[parRobbed]
        if parRobbed:
            root.dp[parRobbed] = self.solve(root.left, 0) + self.solve(root.right, 0)
        else:
            root.dp[parRobbed] = max(self.solve(root.left, 0) + self.solve(root.right, 0), root.val + self.solve(root.left, 1) + self.solve(root.right, 1))
        return root.dp[parRobbed]
    
    def fill(self, root : TreeNode):
        if root:
            root.dp = [None, None]
            self.fill(root.left)
            self.fill(root.right)

    def rob(self, root: Optional[TreeNode]) -> int:
        self.fill(root)
        return self.solve(root, 0)
