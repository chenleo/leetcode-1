/**
 * Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements
 * are sorted in ascending order, convert it
 * to a height balanced BST.
 * 
 * http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    private static ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;
        
        int l = 0;
        ListNode end = head;
        while (end != null) {
            l++;
            end = end.next;
        }
        cur = head;
        return buildTree(0, l - 1);
    }
    
    public static TreeNode buildTree(int low, int high) {
        if (high < low) return null;
        int middle = low + (high - low) / 2;
        TreeNode leftTree = buildTree(low, middle - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode rightTree = buildTree(middle + 1, high);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}