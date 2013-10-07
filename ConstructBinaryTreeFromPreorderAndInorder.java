/**
* Construct Binary Tree from Preorder and Inorder Traversal
* Given preorder and inorder traversal of a tree, construct the binary tree.
*
* Note:
* You may assume that duplicates do not exist in the tree.
*
* http://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr) return null;
        if (pl == pr) return new TreeNode(preorder[pl]);
        
        int rootValue = preorder[pl];
        
        // find root in inorder array
        int rootIndex;
        for (rootIndex = il; rootIndex <= ir; rootIndex++) {
            if (inorder[rootIndex] == rootValue)
                break;
        }
        int leftCount = rootIndex - il;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, pl + 1, pl + leftCount, inorder, il, rootIndex - 1);
        root.right = build(preorder, pl + leftCount + 1, pr, inorder, rootIndex + 1, ir);
        return root;
    }
}