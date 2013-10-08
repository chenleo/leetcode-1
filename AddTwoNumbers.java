/**
* Add Two Numbers
* You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
* 
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
*
* http://oj.leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int plusOne = 0;
        int value;
        ListNode root = null;
        ListNode current = null;
        while (l1 != null && l2 !=null) {
            value = l1.val + l2.val + plusOne;
            plusOne = value / 10;
            value %= 10;
            ListNode newNode = new ListNode(value);
            if (current != null)
                current.next = newNode;
            current = newNode;
            if (root == null) root = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            value = l1.val + plusOne;
            plusOne = value / 10;
            value %= 10;
            ListNode newNode = new ListNode(value);
            if (current != null)
                current.next = newNode;
            current = newNode;
            if (root == null) root = newNode;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            value = l2.val + plusOne;
            plusOne = value / 10;
            value %= 10;
            ListNode newNode = new ListNode(value);
            if (current != null)
                current.next = newNode;
            current = newNode;
            if (root == null) root = newNode;
            l2 = l2.next;
        }
        if (plusOne == 1) { // **important**
            value = 1;
            ListNode newNode = new ListNode(value);
            if (current != null)
                current.next = newNode;
            current = newNode;
            if (root == null) root = newNode;
        }
        return root;
    }
}