/**
 * Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * http://oj.leetcode.com/problems/rotate-image/
 */

public class Solution {
    public void rotate(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = matrix.length;
        
        int left = 0, right = n - 1, up = 0, down = n - 1;
        while (left < right) rotateLevel(matrix, left++, right--, up++, down--);
    }
    
    private void rotateLevel(int[][] matrix, int left, int right, int up, int down) {
        for (int i = 0; i < right - left; i++) {
            int temp = matrix[up][left + i];
            matrix[up][left + i] = matrix[down - i][left];
            matrix[down - i][left] = matrix[down][right - i];
            matrix[down][right - i] = matrix[up + i][right];
            matrix[up + i][right] = temp;
        }
    }
}
