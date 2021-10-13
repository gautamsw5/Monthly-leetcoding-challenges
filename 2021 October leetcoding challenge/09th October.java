class Solution
{
    private class Node
    {
        Node[] children;
        String word;
        Node()
        {
            children = new Node[26];
            word = null;
        }
    }
    
    private Set<String> ans;
    
    private void dfs(char[][] board, int i, int j, Node root)
    {
        if(root != null && root.word != null)
            ans.add(root.word);
        if(root == null || i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j] == '#')
            return;
        char c = board[i][j];
        board[i][j] = '#';
        dfs(board, i+1, j, root.children[c-'a']);
        dfs(board, i, j+1, root.children[c-'a']);
        dfs(board, i-1, j, root.children[c-'a']);
        dfs(board, i, j-1, root.children[c-'a']);
        board[i][j] = c;
    }
    
    private void insert(Node root, char[] s, String S)
    {
        for(char c : s)
        {
            if(root.children[c-'a'] == null)
                root.children[c-'a'] = new Node();
            root = root.children[c-'a'];
        }
        root.word = S;
    }
    
    public List<String> findWords(char[][] board, String[] words)
    {
        Node root = new Node();
        for(String s : words)
            insert(root, s.toCharArray(), s);
        
        ans = new HashSet<>();
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                dfs(board, i, j, root);
                
        return new ArrayList<>(ans);
    }
}
