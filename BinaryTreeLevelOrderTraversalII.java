/**
 * Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 * 
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root != null) {
            ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
            cur.add(0, root);
            
            while (cur.size() > 0) {
                ArrayList<Integer> curInt = new ArrayList<Integer>();
                ArrayList<TreeNode> next = new ArrayList<TreeNode>();
                for (TreeNode node: cur) {
                    curInt.add(node.val);
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                }
                res.add(0, curInt);
                cur = next;
            }
        }
        return res;
    }
}