/**
 * Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * http://oj.leetcode.com/problems/reorder-list/
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
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null || head.next == null) return;
        ListNode slow = head, quick = head.next;
        ListNode tailHead = null;
        while (true) {
            if (quick == null || quick.next == null) {
                tailHead = slow.next;
                break;
            }
            else {
                slow = slow.next;
                quick = quick.next.next;   
            }
        }
        ListNode pre = null, cur = tailHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        tailHead = pre;
        pre = null;
        while (tailHead != null) {
            ListNode next = head.next;
            head.next = tailHead;
            tailHead = tailHead.next;
            head.next.next = next;
            head = next;
        }
        if (head != null) head.next = null;
    }
}
