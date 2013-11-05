/**
 * Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root != null) {
            ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
            cur.add(root);
            
            while (cur.size() > 0) {
                ArrayList<Integer> curInt = new ArrayList<Integer>();
                ArrayList<TreeNode> next = new ArrayList<TreeNode>();
                for (TreeNode node: cur) {
                    curInt.add(node.val);
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                }
                res.add(curInt);
                cur = next;
            }
        }
        return res;
    }
}