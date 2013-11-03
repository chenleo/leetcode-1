/**
 * Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 *
 *    1
 *   / \
 *  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 *
 * http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
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
    private static int sum = 0;

    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) return 0;
        sum = 0;
        go(0, root);
        return sum;
    }
    
    private static void go(int presum, TreeNode root) {
        int newSum = presum * 10 + root.val;

        // **important** path sum can be added only if the node is leaf, i.e both child are null
        if (root.left == null && root.right == null) {
            sum += newSum;
        }
        else if (root.left == null) {
            go(newSum, root.right);
        }
        else if (root.right == null) {
            go(newSum, root.left);
        }
        else {
            go(newSum, root.left);
            go(newSum, root.right);
        }
    }
}
