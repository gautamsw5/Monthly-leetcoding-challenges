class Trie {
    class Node {
        Node[] children;
        boolean isLeaf;
        public Node() {
            children = new Node[26];
            isLeaf = false;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node r = root;
        for(char c : word.toCharArray()) {
            if(r.children[c-'a'] == null) {
                r.children[c-'a'] = new Node();
            }
            r = r.children[c-'a'];
        }
        r.isLeaf = true;
    }
    
    public boolean search(String word) {
        Node r = root;
        for(char c : word.toCharArray()) {
            if(r.children[c-'a'] == null) {
                return false;
            }
            r = r.children[c-'a'];
        }
        return r.isLeaf;
    }
    public boolean startsWith(String prefix) {
        Node r = root;
        for(char c : prefix.toCharArray()) {
            if(r.children[c-'a'] == null) {
                return false;
            }
            r = r.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
