/**
 * Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements 
 * of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * http://oj.leetcode.com/problems/spiral-matrix/
 */

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = matrix.length;
        if (m == 0) return new ArrayList<Integer>();
        int n = matrix[0].length;
        if (n == 0) return new ArrayList<Integer>();
        
        ArrayList<Integer> res = new ArrayList<Integer>();

        int left = 0, right = n - 1, up = 0, down = m - 1;
        while (left < right && up < down) {
            addLayer(matrix, left++, right--, up++, down--, res);
        }
        
        if (left == right) {
            for (int i = up; i<= down; i++)
                res.add(matrix[i][left]);
        }
        else if (up == down) {
            for (int i = left; i<= right; i++)
                res.add(matrix[up][i]);
        }
        return res;
    }
    
    private void addLayer(int[][] matrix, int left, int right, int up, int down, ArrayList<Integer> res) {
        for (int i = left; i < right; i++)
            res.add(matrix[up][i]);
        for (int i = up; i < down; i++)
            res.add(matrix[i][right]);
        for (int i = right; i > left; i--)
            res.add(matrix[down][i]);
        for (int i = down; i > up; i--)
            res.add(matrix[i][left]);
    }
}
