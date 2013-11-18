/**
 * Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * http://oj.leetcode.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return merge(lists, 0, lists.size() - 1);
    }
    
    public static ListNode merge(ArrayList<ListNode> lists, int low, int high) {
        if (low > high) return null;
        if (low == high) return lists.get(low);
        else {
            int middle = low + (high - low) / 2;
            ListNode left = merge(lists, low, middle);
            ListNode right = merge(lists, middle + 1, high);
            return mergeTwo(left, right);
        }
    }
    
    public static ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = null;
        if (l1.val > l2.val) {
            head = l2; // **important** can reuse the original node
            l2 = l2.next;
        }
        else {
            head = l1; // **important** can reuse the original node
            l1 = l1.next;
        }
        
        ListNode cur = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2; // **important** can reuse the original node
                l2 = l2.next;
            }
            else {
                cur.next = l1; // **important** can reuse the original node
                l1 = l1.next;
            }
            cur = cur.next;
        }
        
        while (l1 != null) {
            cur.next = l1; // **important** can reuse the original node
            l1 = l1.next;
            cur = cur.next;
        }
        
        while (l2 != null) {
            cur.next = l2; // **important** can reuse the original node
            l2 = l2.next;
            cur = cur.next;
        }
        
        return head;
    }
}
