class Node {
    Node[] child;
    boolean isLeaf;
    Node() {
        child = new Node[26];
        isLeaf = false;
    }
}
class Solution {
    Node root;
    int ans;
    void insert(Node root, char[] s) {
        for(int i = s.length-1; i >= 0; i--) {
            if(root.child[s[i]-'a'] == null) {
                root.child[s[i]-'a'] = new Node();
            }
            root = root.child[s[i]-'a'];
        }
        root.isLeaf = true;
    }
    void solve(Node root, int d) {
        byte f = 0;
        for(Node r : root.child) {
            if(r != null) {
                solve(r, d+1);
                f = 1;
            }
        }
        if(root.isLeaf && f == 0) {
            ans += d + 1;
        }
    }
    public int minimumLengthEncoding(String[] words) {
        root = new Node();
        for(String s : words) {
            insert(root, s.toCharArray());
        }
        ans = 0;
        solve(root, 0);
        return ans;
    }
}
