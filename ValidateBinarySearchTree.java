/**
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * http://oj.leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode node, int low, int high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        else {
            return isValid(node.left, low, node.val) && isValid(node.right, node.val, high);
        }
    }
    
}