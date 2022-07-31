class Node {
    Node left, right, par;
    int l, r;
    int sum;
    Node() {}
    Node(int sum, int l, int r) {
        this.sum = sum;
        this.l = l;
        this.r = r;
    }
    Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.sum = 0;
    }
}
class NumArray {
    Node[] nodes;
    int n;
    Node root;
    Node buildTree(int l, int r) {
        if(l > r) return null;
        if(l == r) return nodes[l];
        Node root = new Node(l, r);
        int m = (l+r)/2;
        root.left = buildTree(l, m);
        root.right = buildTree(m+1, r);
        if(root.left != null) {
            root.sum += root.left.sum;
            root.left.par = root;
        }
        if(root.right != null) {
            root.sum += root.right.sum;
            root.right.par = root;
        }
        return root;
    }
    int findSum(Node root, int l, int r) {
        if(l > r || root == null) return 0;
        int m = (root.l+root.r)/2;
        // System.out.println(l+" "+r+" "+root.l+" "+root.r+" "+m);
        if(root.l == l && root.r == r) return root.sum;
        
        if(r <= m) return findSum(root.left, l, r);
        else if(l > m) {
            if(root.right != null)
            // System.out.println("r "+root.right.l+" "+root.right.r+" "+root.right.sum);
            return findSum(root.right, l, r);
        }
        return findSum(root.left, l, Math.min(r, m)) + findSum(root.right, Math.max(l, m+1), r);
    }
    public NumArray(int[] arr) {
        n = arr.length;
        nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(arr[i], i, i);
        }
        root = buildTree(0, n-1);
    }
    public void update(int i, int val) {
        nodes[i].sum = val;
        Node x = nodes[i].par;
        while(x != null) {
            x.sum = 0;
            if(x.left != null) x.sum += x.left.sum;
            if(x.right != null) x.sum += x.right.sum;
            x = x.par;
        }
        // System.out.println(root.sum+" "+root.left.sum+" "+root.right.sum);
    }
    public int sumRange(int a, int b) {
        // System.out.println();
        return findSum(root, a, b);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
