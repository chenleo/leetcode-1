/**
* Remove Duplicates from Sorted List
* Given a sorted linked list, delete all duplicates such that each element appear only once.
* 
* For example,
* Given 1->1->2, return 1->2.
* Given 1->1->2->3->3, return 1->2->3.
* 
* http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;

        HashMap<Integer, Boolean> occur = new HashMap<Integer, Boolean>();  // **important**
        ListNode pre = head, cur = head.next;
        occur.put(head.val, true); // **important**
        while (cur != null) {
            if (occur.get(cur.val) != null) {
                pre.next = cur.next;
            }
            else {
                occur.put(cur.val, true);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}