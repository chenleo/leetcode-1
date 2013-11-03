/*
 * Surrounded Regions
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * http://oj.leetcode.com/problems/surrounded-regions/
 */

public class Solution {
    private static Queue<Integer> _queue = null;
    private static char[][] _board;
    private static int _rows = 0;
    private static int _cols = 0;

    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        _queue = new LinkedList<Integer>();
        _board = board;
        _rows = board.length;
        _cols = board[0].length;
        
        for (int i = 0; i < _rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, _cols - 1);
        }
        
        for (int j = 1; j < _cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(_rows - 1, j);
        }
        
        while (!_queue.isEmpty()) {
             int cur = _queue.poll();
             int x = cur / _cols,
                 y = cur % _cols;
                 
             if (_board[x][y] == 'O') {
                 _board[x][y] = 'D';
             }
             
             enqueue(x - 1, y);
             enqueue(x + 1, y);
             enqueue(x, y - 1);
             enqueue(x, y + 1);
        }
        
        for (int i = 0; i < _rows; i++) {
            for (int j = 0; j < _cols; j++) {
                if (_board[i][j] == 'D') _board[i][j] = 'O';
                else if (_board[i][j] == 'O') _board[i][j] = 'X';
            }
        }
        
        _queue = null;
        _board = null;
        _rows = 0;
        _cols = 0;
    }
    
    public static void enqueue(int x, int y) {
        if (x >= 0 && x < _rows && y >= 0 && y < _cols && _board[x][y] == 'O') _queue.offer(x * _cols + y);
    }
}
