/**
 * Edit Distance 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * http://oj.leetcode.com/problems/edit-distance/
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        
        int c1 = 0;
        int[] cur = new int[n + 1];
        for (int i = 0; i < n + 1; i++) cur[i] = i;
        
        while (c1 < m) {
            c1++;
            int[] next = new int[n + 1];
            next[0] = c1;
            for (int i = 1; i < n + 1; i++) {
                if (word1.charAt(c1 - 1) == word2.charAt(i - 1)) next[i] = cur[i - 1];
                else next[i] = Math.min(Math.min(cur[i - 1], cur[i]), next[i - 1]) + 1;
            }
            cur = next;
        }
        
        
        return cur[n];
    }
}