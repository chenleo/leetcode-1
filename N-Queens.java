/**
 * ˘N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n
 * chessboard such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 * http://oj.leetcode.com/problems/n-queens/
 */

public class Solution {
    private ArrayList<ArrayList<Integer>> res = null;
    public ArrayList<String[]> solveNQueens(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) return new ArrayList<String[]>();

        res = new ArrayList<ArrayList<Integer>>();
        boolean[] yused = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1];
        boolean[] subDiag = new boolean[2 * n - 1];
        int[] cols = new int[n];
        
        go(n, 0, cols, yused, mainDiag, subDiag);
        
        ArrayList<String[]> ret = new ArrayList<String[]>();
        for (ArrayList<Integer> solution: res) {
            String[] board = new String[n];
            for (int i = 0; i < n; i++) {
                char[] charArray = new char[n];
                for (int j = 0; j < n; j++) charArray[j] = '.';
                charArray[solution.get(i)] = 'Q';
                board[i] = new String(charArray);
            }
            ret.add(board);
        }
        
        return ret;
    }
    
    private void go(int n, int c, int[] cols, boolean[] yused, boolean[] mainDiag, boolean[] subDiag) {
        if (c == n) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) solution.add(cols[j]);
            res.add(solution);
        }
        else {
            for (int j = 0; j < n; j++) {
                if (!yused[j] && !mainDiag[c + j] && !subDiag[c - j + (n - 1)]){
                    yused[j] = true;
                    mainDiag[c + j] = true;
                    subDiag[c - j + (n - 1)] = true;
                    cols[c] = j;
                    go(n, c + 1, cols, yused, mainDiag, subDiag);
                    subDiag[c - j + (n - 1)] = false;
                    mainDiag[c + j] = false;
                    yused[j] = false;
                }
            }
        }
        
    }
}
