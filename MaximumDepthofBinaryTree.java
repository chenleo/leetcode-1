/**
* Maximum Depth of Binary Tree
* Given a binary tree, find its maximum depth.
* 
* The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
* 
* http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) return 0;
        else {
            int lh = root.left == null ? 0 : maxDepth(root.left);
            int rh = root.right == null ? 0 : maxDepth(root.right);
            return 1 + (lh > rh ? lh : rh);
        }
    }
}