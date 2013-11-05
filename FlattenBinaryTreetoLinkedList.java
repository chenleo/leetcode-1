/**
 * Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * click to show hints.
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right
 * child points to the next node of a pre-order traversal.    
 * 
 * http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
    public void flatten(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        root = flat(root);
    }
    
    private TreeNode flat(TreeNode node) {
        if (node == null) return null;
        TreeNode left = flat(node.left);
        TreeNode right = flat(node.right);
        
        node.left = null;
        node.right = left;
        TreeNode cur = node;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
        return node;
    }
}