/**
 * Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * http://oj.leetcode.com/problems/partition-list/
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
    public ListNode partition(ListNode head, int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode sh = null, st = null, lh = null, lt = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (sh == null) sh = cur;
                if (st ==  null) st = cur;
                else {
                    st.next = cur;
                    st = st.next;
                }
            }
            else{
                if (lh == null) lh = cur;
                if (lt ==  null) lt = cur;
                else {
                    lt.next = cur;
                    lt = lt.next;
                }
            }
            cur = cur.next;
        }
        if (sh == null) {
            sh = lh;
        }
        else {
            st.next = lh;
        }
        
        if (lh == null) {
            //
        }
        else {
            lt.next = null;
        }
        
        return sh;
    }
}