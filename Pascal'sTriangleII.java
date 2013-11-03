/**
 * Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * http://oj.leetcode.com/problems/pascals-triangle-ii/ 
 */

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int level = 0;
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(1);

        while (level < rowIndex) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int i = 0; i < last.size() - 1; i++) {
                cur.add(last.get(i) + last.get(i + 1));
            }
            cur.add(1);
            level++;
            last = cur;
        }
        
        return last;
    }
}
