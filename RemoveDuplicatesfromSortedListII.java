/**
 * Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode last = null, cur = head;
        while (cur != null) {
            ListNode end = cur;
            while (end.next != null && end.next.val == cur.val) end = end.next;
            if (end == cur) {
                if (last == null) last = cur;
                else last.next = cur;
                last = cur;
            }
            else {
                if (cur == head) head = end.next;
            }
            cur = end.next;
        }
        if (last != null) last.next = null; // **important** don't forget set the end
        return head;
    }
}