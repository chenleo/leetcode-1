/**
* Minimum Path Sum
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
* 
* Note: You can only move either down or right at any point in time.
* 
* http://oj.leetcode.com/problems/minimum-path-sum/
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int rows = grid.length;
        int cols = grid[0].length;

        int[] lastRow = new int[cols];
        
        int i = 0;
        int sum = 0;
        for (int j = 0; j < cols; j++) {
            sum += grid[0][j];
            lastRow[j] = sum;
        }
        
        sum = grid[0][0];
        i = 1;
        while (i < rows) {
            int[] thisRow = new int[cols];

            sum += grid[i][0];
            thisRow[0] = sum;
            for (int j = 1; j < cols; j++) {
                thisRow[j] = (thisRow[j-1] < lastRow[j] ? thisRow[j-1] : lastRow[j]) + grid[i][j];
            }
            i++;
            lastRow = thisRow;
        }
        
        return lastRow[cols - 1];
    }
}