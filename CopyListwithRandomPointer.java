/**
* Copy List with Random Pointer
* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
*
* Return a deep copy of the list.
*
* http://oj.leetcode.com/problems/copy-list-with-random-pointer/
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null; // **important**
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        
        cur = head;
        while (cur != null) {
            if (cur.random == null) cur.next.random = null; // **important**
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode newHead = head.next, copyCur = newHead;
        while (cur != null) {
            cur.next = copyCur.next;
            if (cur.next != null) { // **important**
                copyCur.next = cur.next.next;
                copyCur = copyCur.next;
            }
            cur = cur.next;
        }
        
        return newHead;
    }
}