/**
 * Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * http://oj.leetcode.com/problems/pascals-triangle/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (numRows > 0) {
            int level = 1;
            ArrayList<Integer> last = new ArrayList<Integer>();
            last.add(1);
            res.add(last);
            
            while (level < numRows) {
                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(1);
                for (int i = 0; i < last.size() - 1; i++) {
                    cur.add(last.get(i) + last.get(i + 1));
                }
                cur.add(1);
                res.add(cur);
                level++;
                last = cur;
            }
        }
        return res;
    }
}
