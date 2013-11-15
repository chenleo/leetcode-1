/**
 * Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 * 
 * http://oj.leetcode.com/problems/maximal-rectangle/
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (matrix.length == 0) return 0;

        int[] lastRowHeight = new int[matrix[0].length + 1];
        for (int j = 0; j < matrix[0].length; j++) {
            lastRowHeight[j] = matrix[0][j] == '1' ? 1 : 0;
        }
        lastRowHeight[matrix[0].length] = -1;
        int max = maxAreaInRow(lastRowHeight);

        for (int i = 1; i < matrix.length; i++) {
            int[] thisRowHeight = new int[matrix[i].length + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                thisRowHeight[j] = matrix[i][j] == '1' ? lastRowHeight[j] + 1 : 0;
            }
            thisRowHeight[matrix[i].length] = -1;
            int iMax = maxAreaInRow(thisRowHeight);
            if (iMax > max) max = iMax;
            lastRowHeight = thisRowHeight;
        }
        
        return max;
    }
    
    private int maxAreaInRow(int[] h) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        int i = 0;
        while (i < h.length) {
            if (stack.empty() || h[i] >= h[stack.peek()]) {
                stack.push(i++);
            }
            else {
                int height = h[stack.pop()];
                int width = i - (stack.empty() ? -1 : stack.peek()) - 1;
                int area = height * width;
                if (area > max) max = area;
            }
        }
        
        return max;
    }
}