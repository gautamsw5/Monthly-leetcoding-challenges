class Node {
    Node[] child;
    int index;
    Node() {
        child = new Node[27];
        index = -1;
    }
}
class WordFilter {
    
    Node root;
    void insert(Node root, char[] s, int index) {
        for(int i = 0; i < s.length; i++) {
            if(root.child[s[i]-'a'] != null) {
                root = root.child[s[i]-'a'];
            } else {
                root.child[s[i]-'a'] = new Node();
                root = root.child[s[i]-'a'];
            }
        }
        root.index = Math.max(index, root.index);
    }
    int maxIndex(Node root) {
        int ans = root.index;
        for(Node r : root.child) {
            if(r != null) {
                ans = Math.max(ans, maxIndex(r));
            }
        }
        return ans;
    }
    int find(Node root, char[] s) {
        for(int i = 0; i < s.length; i++) {
            if(root.child[s[i]-'a'] == null) {
                return -1;
            } else {
                root = root.child[s[i]-'a'];
            }
        }
        return maxIndex(root);
    }
    public WordFilter(String[] words) {
        root = new Node();
        for(int index = 0; index < words.length; index++) {
            String s = words[index];
            for(int i = 0; i < s.length()+1; i++) {
                // System.out.println(s.substring(i)+"#"+s);
                insert(root, (s.substring(i)+"{"+s).toCharArray(), index);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return find(root, (suffix+"{"+prefix).toCharArray());
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
