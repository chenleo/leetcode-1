/**
 * Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * http://oj.leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode m_1th = null, mth = head;
        int i = 1;
        while (i++ < m) {
            m_1th = mth;
            mth = mth.next;
        }
        
        ListNode nth = head, n_next = nth.next;
        i = 1;
        while (i++ < n) {
            nth = nth.next;
            n_next = nth.next;
        }
        
        if (m_1th == null) head = nth;
        else m_1th.next = nth;
        
        for (ListNode cur = mth, next = cur.next; cur != nth;) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        
        mth.next = n_next; // **important** not n_next instead of nth.next, because nth.next is already modified
        return head;
    }
}