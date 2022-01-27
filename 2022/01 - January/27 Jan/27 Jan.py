class Node:
    def __init__(self, v):
        self.left = None
        self.right = None
        self.val = v
class Solution:
    def build(self, root, s, i):
        if i==len(s):
            return
        if s[i]=='0':
            if root.left==None:
                root.left = Node(0)
            self.build(root.left, s, i+1)
        else:
            if root.right==None:
                root.right = Node(1)
            self.build(root.right, s, i+1)
    def binn(self, x, n):
        s = ""
        while x>0:
            s = str(x%2) + s
            x = x//2
        return max(0,n-len(s))*"0"+s
    def dec(self, s):
        n = 0
        for i in range(len(s)):
            n = n*2 + int(s[i])
        return n
    def allPaths(self, root, cur):
        if root.left==None and root.right==None:
            print(cur+str(root.val))
            return
        if root.left!=None:
            self.allPaths(root.left, cur+str(root.val))
        if root.right!=None:
            self.allPaths(root.right, cur+str(root.val))
    def solve(self, a, b, ap, bp):
        if a.left==None and b.right==None and a.right==None and b.right==None:
            # print(ap,bp)
            return self.dec(ap+str(a.val))^self.dec(bp+str(b.val))
        ans = 0
        if (a.left!=None and b.right!=None) or (a.right!=None and b.left!=None):
            if a.left!=None and b.right!=None:
                ans = max(ans, self.solve(a.left, b.right, ap+str(a.val), bp+str(b.val)))
            if a.right!=None and b.left!=None:
                ans = max(ans, self.solve(a.right, b.left, ap+str(a.val), bp+str(b.val)))
        else:
            if a.left==None and b.right!=None and a.right!=None:
                ans = max(ans, self.solve(a.right, b.right, ap+str(a.val), bp+str(b.val)))
            if b.right==None and b.left!=None and a.left!=None:
                ans = max(ans, self.solve(a.left, b.left, ap+str(a.val), bp+str(b.val)))
        return ans
    def findMaximumXOR(self, arr: List[int]) -> int:
        arr.sort()
        n = len(arr)
        arr[n-1] = self.binn(arr[n-1], 0)
        for i in range(n-2, -1, -1):
            arr[i] = self.binn(arr[i], len(arr[n-1]))
        root = Node(0)
        for i in arr:
            self.build(root, i, 0)
        ap = ""
        bp = ""
        while root!=None and (root.left==None or root.right==None):
            ap += str(root.val)
            bp += str(root.val)
            if root.left==None:
                root = root.right
            else:
                root = root.left
        if root==None:
            return 0
        return self.solve(root.left, root.right, ap, bp)
