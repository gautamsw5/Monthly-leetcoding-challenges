class Node {
    Node[] child;
    boolean isLeaf;
    Node() {
        child = new Node[26];
        isLeaf = false;
    }
}
class StreamChecker {

    String[] words;
    Node root;
    StringBuilder sb;
    
    public StreamChecker(String[] words) {
        root = new Node();
        this.words = words;
        sb = new StringBuilder();
        for(String s : words) {
            Node r = root;
            for(int i = s.length()-1; i > -1; i--) {
                if(r.child[s.charAt(i)-'a'] == null) r.child[s.charAt(i)-'a'] = new Node();
                r = r.child[s.charAt(i)-'a'];
            }
            r.isLeaf = true;
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Node r = root;
        for(int i = sb.length()-1; i > -1; i--) {
            r = r.child[sb.charAt(i)-'a'];
            if(r == null) break;
            if(r.isLeaf) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
