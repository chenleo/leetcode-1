/**
 * N-Queens II
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations,
 * return the total number of distinct solutions.
 * 
 * http://oj.leetcode.com/problems/n-queens-ii/
 */

public class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) return 0;

        res = 0;
        boolean[] yused = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1];
        boolean[] subDiag = new boolean[2 * n - 1];
        int[] cols = new int[n];
        
        go(n, 0, cols, yused, mainDiag, subDiag);
        
        return res;
    }
    
    private void go(int n, int c, int[] cols, boolean[] yused, boolean[] mainDiag, boolean[] subDiag) {
        if (c == n) res++;
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