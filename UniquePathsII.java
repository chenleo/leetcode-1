/**
 * Unique Paths II
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * http://oj.leetcode.com/problems/unique-paths-ii/
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            res[i] = 1;
        }
        
        boolean firstColumnBlocked = obstacleGrid[0][0] == 1;
        for (int level = 1; level < m; level++) {
            int[] newRes = new int[n];
            if (obstacleGrid[level][0] == 1 || firstColumnBlocked) firstColumnBlocked = true;
    
            if (firstColumnBlocked) newRes[0] = 0;
            else newRes[0] = 1;

            for (int i = 1; i < n; i++) {
                if (obstacleGrid[level][i] == 1) newRes[i] = 0;
                else newRes[i] = newRes[i - 1] + res[i];
            }
            res = newRes;
        }
        
        return res[n - 1];
    }
}
