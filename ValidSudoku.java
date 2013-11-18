/**
 * Valid Sudoku
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * http://oj.leetcode.com/problems/valid-sudoku/
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = board.length;
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.')
                    row[board[i][j] - '1']++;
                if (board[j][i] != '.')
                    col[board[j][i] - '1']++; 
            }
            for (int j = 0; j < n; j++) {
                if (row[j] > 1 || col[j] > 1) return false;
            }
        }
        
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                int[] block = new int[9];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++){
                        if (board[k][l] != '.')
                            block[board[k][l] - '1']++;
                    }
                }
                for (int k = 0; k < 9; k++)
                    if (block[k] > 1) return false;
            }
        }
        return true;
    }
}
