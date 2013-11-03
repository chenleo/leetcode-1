/**
 * Linked List Cycle 
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * http://oj.leetcode.com/problems/linked-list-cycle/
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return false;
        ListNode slow = head, quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            if (slow == quick.next || slow == quick.next.next) return true;
            quick = quick.next.next;
        }
        return false;
        
    }
}
