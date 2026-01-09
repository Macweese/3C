/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

typedef struct
{
    struct TreeNode* node;
    int depth;
} Result;

Result helper(struct TreeNode* root, int depth)
{
    if (root == NULL)
    {
        Result res = {NULL, depth};
        return res;
    }

    Result left = helper(root->left, depth + 1);
    Result right = helper(root->right, depth + 1);

    Result res;

    if (left.depth == right.depth)
    {
        res.node = root;
        res.depth = left.depth;
    }
    else if (left.depth > right.depth)
    {
        res.node = left.node;
        res.depth = left.depth;
    }
    else
    {
        res.node = right.node;
        res.depth = right.depth;
    }

    return res;
}

struct TreeNode* subtreeWithAllDeepest(struct TreeNode* root)
{
    Result res = helper(root, 0);
    return res.node;
}
