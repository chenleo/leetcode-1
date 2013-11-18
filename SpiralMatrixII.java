/**
 * Spiral Matrix II 
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * http://oj.leetcode.com/problems/spiral-matrix-ii/
 */

public class Solution {
    private int val = 0;
    public int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        this.val = 0;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        while (left < right && up < down) {
            addLayer(matrix, left++, right--, up++, down--);
        }
        
        if (left == right) {
            fill(matrix, left, up);
        }
        return matrix;
    }
    
    private void addLayer(int[][] matrix, int left, int right, int up, int down) {
        for (int i = left; i < right; i++)
            fill(matrix, up, i);
        for (int i = up; i < down; i++)
            fill(matrix, i, right);
        for (int i = right; i > left; i--)
            fill(matrix, down, i);
        for (int i = down; i > up; i--)
            fill(matrix, i, left);
    }
    
    private void fill(int[][] matrix, int x, int y) {
        this.val++;
        matrix[x][y] = this.val;
    }
}
