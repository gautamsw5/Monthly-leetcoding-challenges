class Node {
    public:
    vector<Node*> child;
    bool isLeaf;
    Node() {
        child = vector<Node*>(26, NULL);
        isLeaf = false;
    }
};
class WordDictionary {
public:
    Node* root;
    WordDictionary() {
        root = new Node();
    }
    void insert(Node* root, string& word) {
        for(int i = 0; i < word.length(); i++) {
            if(root->child[word[i]-'a'] == NULL) {
                root->child[word[i]-'a'] = new Node();
            }
            root = root->child[word[i]-'a'];
        }
        root->isLeaf = 1;
    }
    bool find(Node* root, string& word, int i) {
        if(root == NULL) return 0;
        while(i < word.length()) {
            if(word[i] == '.') {
                for(int j = 0; j < 26; j++) if(find(root->child[j], word, i+1)) return 1;
                return 0;
            }
            if(root->child[word[i]-'a'] == NULL) return 0;
            root = root->child[word[i++]-'a'];
        }
        return root->isLeaf;
    }
    void addWord(string word) {
        insert(root, word);
    }
    
    bool search(string word) {
        return find(root, word, 0);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
