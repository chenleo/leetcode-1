/**
* Merge Two Sorted Lists
* Merge two sorted linked lists and return it as a new list.
* 
* The new list should be made by splicing together the nodes of the first two lists.
* 
* http://oj.leetcode.com/problems/merge-two-sorted-lists/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = null, cur = null;
        while (l1 != null && l2 != null) {
            ListNode newNode = null;
            if (l1.val < l2.val) { // **important**
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            else { // **important**
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (cur != null) cur.next = newNode;
            else cur = newNode; // **important**
            if (head == null) head = cur;
            cur = newNode;
        }
        
        while (l1 != null) {
            ListNode newNode = new ListNode(l1.val);
            if (cur != null) cur.next = newNode;
            cur = newNode;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            ListNode newNode = new ListNode(l2.val);
            if (cur != null) cur.next = newNode;
            cur = newNode;
            l2 = l2.next;
        }
        return head;
    }
}