/**
 * Populating Next Right Pointers in Each Node II
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        TreeLinkNode head = root;
        
        while (head != null) {
            TreeLinkNode newHead = null, cur = head, curNext = null;
            while (cur != null) {
               if (cur.left != null) {
                   if (newHead == null) newHead = cur.left;
                   if (curNext == null) curNext = cur.left;
                   else {
                       curNext.next = cur.left;
                       curNext = curNext.next;
                   }
               }
               if (cur.right != null) {
                   if (newHead == null) newHead = cur.right;
                   if (curNext == null) curNext = cur.right;
                   else {
                       curNext.next = cur.right;
                       curNext = curNext.next;
                   }
               }
               cur = cur.next;
            }
            head = newHead;
        }
        
    }
}