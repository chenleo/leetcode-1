/**
 * Triangle 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * http://oj.leetcode.com/problems/triangle/
 */

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (triangle.size() == 0) return 0;

        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(triangle.get(0).get(0)); // add the root
        
        for (int i = 1; i < triangle.size(); i++) {
            ArrayList<Integer> level = triangle.get(i);
            ArrayList<Integer> next = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                int sum = level.get(j);
                if (j == 0) sum += cur.get(j);
                else if (j == i) sum += cur.get(j - 1);
                else sum += Math.min(cur.get(j - 1), cur.get(j));
                next.add(sum);
            }
            cur = next;
        }

        int min = Integer.MAX_VALUE;
        for (int i: cur) {
            if (min > i) min = i;
        }
        return min;
    }
}
