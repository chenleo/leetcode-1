/**
 * Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * http://oj.leetcode.com/problems/sort-list/
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
    public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null || head.next == null) return head;
        
        // find middle
        ListNode slow = head, quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        
        // spilt
        ListNode second = slow.next;
        slow.next = null;
        ListNode first = sortList(head);
        second = sortList(second);
        
        // merge
        head = null;
        ListNode cur = null;
        
        while (first != null && second != null) {
            ListNode node = null;
            if (first.val < second.val) {
                node = first;
                first = first.next;
            }
            else {
                node = second;
                second = second.next;
            }
            
            if (head == null) {
                head = node;
                cur = node;
            }
            else {
                cur.next = node;
                cur = cur.next;
            }
        }
        
        while (first != null) {
            ListNode node = first;
            first = first.next;
            
            if (head == null) {
                head = node;
                cur = node;
            }
            else {
                cur.next = node;
                cur = cur.next;
            }
        }
        
        while (second != null) {
            ListNode node = second;
            second = second.next;
            
            if (head == null) {
                head = node;
                cur = node;
            }
            else {
                cur.next = node;
                cur = cur.next;
            }
        }
        
        return head;
    }
}
