/**
 * Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * http://oj.leetcode.com/problems/word-search/
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        if (n == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = ' ';
                    if (check(board, word.substring(1), i, j))
                        return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, String word, int x, int y) {
        if (word.length() == 0) return true;
        int[][] steps = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};
        int m = board.length, n = board[0].length;

        for (int[] step: steps) {
            int i = step[0], j = step[1];
            if (i >= 0 && j >= 0 && i < m && j < n && board[i][j] == word.charAt(0)) {
                board[i][j] = ' ';
                if (check(board, word.substring(1), i, j))
                    return true;
                board[i][j] = word.charAt(0);
            }
        }
        return false;
    }
}