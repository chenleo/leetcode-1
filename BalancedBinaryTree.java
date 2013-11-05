/**
 * Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined
 * as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * http://oj.leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}