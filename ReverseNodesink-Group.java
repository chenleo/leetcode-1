/**
 * Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and 
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the 
 * end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be 
 * changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * http://oj.leetcode.com/problems/reverse-nodes-in-k-group/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode start = head, pre = null, next = null;
        
        while (start != null) {
            ListNode end = start;
            for (int i = 0; i < k - 1; i++) {
                end = end.next;
                if (end == null) return head;
            }
            
            next = end.next;
            
            // reverse
            for (ListNode last = start, cur = start.next; last != end;) {
                ListNode temp = cur.next;
                cur.next = last;
                last = cur;
                cur = temp;
            }
            if (pre != null) {
                pre.next = end;
            }
            else head = end;
            pre = start;
            start.next = next;
            start = next;
        }
        
        return head;
    }
}
