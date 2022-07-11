/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        queue<TreeNode*> q; if(root != NULL) q.push(root);
        while(!q.empty()) {
            int n = q.size();
            int t = -1;
            for(int i = 0; i < n; i++) {
                TreeNode* u = q.front(); q.pop();
                t = u->val;
                if(u->left != NULL) q.push(u->left);
                if(u->right != NULL) q.push(u->right);
            }
            ans.push_back(t);
        }
        return ans;
    }
};
