/**
 * Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * http://oj.leetcode.com/problems/recover-binary-search-tree/
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
    private TreeNode earlier = null;
    private TreeNode later = null;
    private TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        earlier = null;
        later = null;
        pre = null;
        find(root);
        int temp = later.val;
        later.val = earlier.val;
        earlier.val = temp;
    }
    
    private void find(TreeNode node) {
        if (node == null) return;

        find(node.left);

        if (pre != null && pre.val >= node.val) {
            if (earlier == null) earlier = pre; // **important** imagine the inorder array
            later = node; // **important** keep this value first, may be changed later
        }
        pre = node;

        find(node.right);
    }
}