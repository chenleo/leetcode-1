/**
* Swap Nodes in Pairs
* Given a linked list, swap every two adjacent nodes and return its head.
* 
* For example,
* Given 1->2->3->4, you should return the list as 2->1->4->3.
* 
* Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
* 
* http://oj.leetcode.com/problems/swap-nodes-in-pairs/
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
    public ListNode swapPairs(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if (head == null || head.next == null) return head;
        
        ListNode oldHead = head;
        head = head.next;
        oldHead.next = head.next;
        head.next = oldHead;
        
        ListNode pre = head.next;
        ListNode cur = head.next.next;
        
        while (cur != null && cur.next != null) {
            ListNode old = cur;
            cur = cur.next;
            old.next = cur.next;
            cur.next = old;
            pre.next = cur; // **important**
            
            pre = cur.next;
            cur = pre.next;
        }
        
        return head;
    }
}