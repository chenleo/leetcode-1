/**
* Construct Binary Tree from Inorder and Postorder Traversal
* Given inorder and postorder traversal of a tree, construct the binary tree.
*
* Note:
* You may assume that duplicates do not exist in the tree.
*
* http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (pl > pr) return null;
        if (pl == pr) return new TreeNode(postorder[pr]);
        
        int rootValue = postorder[pr];
        
        // find rootIndex in inorder
        int rootIndex;
        for (rootIndex = il; rootIndex <= ir; rootIndex++) {
            if (inorder[rootIndex] == rootValue)
                break;
        }
        int leftCount = rootIndex - il;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, il, rootIndex - 1, postorder, pl, pl + leftCount - 1);
        root.right = build(inorder, rootIndex + 1, ir, postorder, pl + leftCount, pr - 1);
        return root;
    }
}