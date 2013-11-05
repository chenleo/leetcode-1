/**
 * Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in
 * ascending order, convert it to a height
 * balanced BST.
 * 
 * http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return atob(num, 0, num.length - 1);
    }
    
    public static TreeNode atob(int[] num, int low, int high) {
        if (low > high) return null;

        int middle = low + (high - low) / 2;
        TreeNode root = new TreeNode(num[middle]);
        TreeNode left = atob(num, low, middle - 1);
        root.left = left;
        TreeNode right = atob(num, middle + 1, high);
        root.right = right;
        return root;
    }
}