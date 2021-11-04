class Solution:
    def paths(self, root, cur):
        if root==None:
            return
        if root.left==None and root.right==None:
            #print(cur + str(root.val))
            self.ans += int(cur + str(root.val))
        self.paths(root.left, cur + str(root.val))
        self.paths(root.right, cur + str(root.val))
    def sumNumbers(self, root: TreeNode) -> int:
        self.ans = 0
        self.paths(root,"0")
        return self.ans
