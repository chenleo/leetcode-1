/**
 * Binary Tree Maximum Path Sum
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 *
 * Return 6.
 *
 * http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) return 0;
        
        maxSum = Integer.MIN_VALUE;

        maxPathRoot(root);
        return maxSum;
    }
    
    private int maxPathRoot(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathRoot(root.left);
        int right = maxPathRoot(root.right);
        int maxSide = Math.max(left, right);
        int oneSide = root.val + Math.max(maxSide, 0); // **important** three cases: with left, with right or only the root node

        // **important** update global maxSum
        int curMax = root.val;
        if (left > 0) curMax += left;
        if (right > 0) curMax += right;
        maxSum = Math.max(maxSum, curMax);

        return oneSide;
    }
}
