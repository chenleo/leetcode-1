/**
 * Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 
 * http://oj.leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) return true;

        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        
        boolean shouldContinue = true;
        while (shouldContinue) {
            for (int i = 0, j = cur.size() - 1; i < j; i++, j--) {
                TreeNode node1 = cur.get(i), node2 = cur.get(j);
                if (node1 == null && node2 == null) continue;
                else if (node1 == null || node2 == null || node1.val != node2.val) return false;
            }

            shouldContinue = false;
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            for (int i = 0; i < cur.size(); i++) {
                TreeNode node = cur.get(i);
                if (node != null) {
                    next.add(node.left);
                    next.add(node.right);
                    if (node.left != null || node.right != null) shouldContinue = true;
                }
            }
            cur = next;
        }
        return true;
        
    }
}