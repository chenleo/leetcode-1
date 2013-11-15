/**
 * Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * http://oj.leetcode.com/problems/search-a-2d-matrix/
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        
        if (target < matrix[0][0]) return false;

        int low = 0, high = m - 1;
        int targetrow = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (matrix[middle][0] == target) return true;
            if (target > matrix[middle][0] && (middle == m - 1 || target < matrix[middle + 1][0])) {
                targetrow = middle;
                break;
            }
            if (matrix[middle][0] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        
        low = 0;
        high = n - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (matrix[targetrow][middle] == target) return true;
            if (matrix[targetrow][middle] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return false;
    }
}
