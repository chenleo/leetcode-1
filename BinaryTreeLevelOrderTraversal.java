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