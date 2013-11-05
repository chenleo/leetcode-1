/**
 * Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each
 * path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 
 * http://oj.leetcode.com/problems/path-sum-ii/
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            // return empty res
        }
        else if (root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> s = new ArrayList<Integer>();
            s.add(root.val);
            res.add(s);
        }
        else {
            int newsum = sum - root.val;
            ArrayList<ArrayList<Integer>> left = pathSum(root.left, newsum);
            for (ArrayList<Integer> l: left) {
                l.add(0, root.val);
                res.add(l);
            }
            ArrayList<ArrayList<Integer>> right = pathSum(root.right, newsum);
            for (ArrayList<Integer> r: right) {
                r.add(0, root.val);
                res.add(r);
            }
        }
        return res;
    }
}