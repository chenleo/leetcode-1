/**
 * Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * http://oj.leetcode.com/problems/unique-paths/
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        
        int[] res = new int[m];
        for (int i = 0; i < m; i++) res[i] = 1;
        
        for (int level = 1; level < n; level++) {
            int[] newRes = new int[m];
            newRes[0] = 1;
            for (int i = 1; i < m; i++) newRes[i] = newRes[i - 1] + res[i];
            res = newRes;
        }
        
        return res[m - 1];
    }
}
