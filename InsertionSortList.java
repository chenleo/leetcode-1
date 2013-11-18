/**
 * Insertion Sort List
 * Sort a linked list using insertion sort.
 * 
 * http://oj.leetcode.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode curNode = dummy.next;

        while (curNode != null) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;

            while (cur.val < curNode.val) {
                pre = cur;
                cur = cur.next;
            }

            if (cur != curNode) {
                pre.next = curNode;
                preNode.next = curNode.next;
                curNode.next = cur;
                curNode = preNode;
            }

            preNode = curNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }
}
