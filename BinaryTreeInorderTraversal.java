/**
 * Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!s.empty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            else {
                cur = s.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}

// public class Solution {
//     public ArrayList<Integer> inorderTraversal(TreeNode root) {
//         // IMPORTANT: Please reset any member data you declared, as
//         // the same Solution instance will be reused for each test case.
//         ArrayList<Integer> res = new ArrayList<Integer>();
//         if (root == null) return res;
//         if (root.left != null) {
//             ArrayList<Integer> left = inorderTraversal(root.left);
//             res.addAll(left);
//         }
        
//         res.add(root.val);
        
//         if (root.right != null) {
//             ArrayList<Integer> right = inorderTraversal(root.right);
//             res.addAll(right);
//         }
//         return res;
//     }
// }