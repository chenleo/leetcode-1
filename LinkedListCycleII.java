/**
 * Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * http://oj.leetcode.com/problems/linked-list-cycle-ii/
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
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return null;

        ListNode slow = head, quick = head.next;
        
        while (slow != quick) {
            if (quick == null || quick.next == null) return null;
            else {
                quick = quick.next.next;
                slow = slow.next;
            }
        }
        
        quick = head;
        slow = slow.next; //**important** by "quick = head", the quick has already walked one step
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}
