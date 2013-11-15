/**
 * Scramble String
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * http://oj.leetcode.com/problems/scramble-string/
 */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = s1.length();
        if (m != s2.length() || !similar(s1, s2)) return false;
        
        boolean[][][] res = new boolean[m][m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                res[0][i][j] = s1.charAt(i) == s2.charAt(j);
        }
        
        for (int k = 1; k < m; k++) { // length is k + 1
            for (int i = 0; i < m - k; i++) {
                for (int j = 0; j < m - k; j++) {
                    boolean r = false;
                    for (int l = 1; l <= k; l++) {
                        if ((res[l - 1][i][j] && res[k - l][i + l][j + l]) || 
                            (res[k - l][i][j + l] && res[l - 1][i + k - l + 1][j])) {
                            r = true;
                            break;
                        }
                    }
                    res[k][i][j] = r;
                }
            }
        }
        
        return res[m - 1][0][0];
    }
    
    private boolean similar(String s1, String s2) {
        int[] need = new int[256];
        for (int i = 0; i < s1.length(); i++) need[s1.charAt(i)]++;
        for (int i = 0; i < s2.length(); i++) need[s2.charAt(i)]--;
        for (int i = 0; i < 256; i++) if (need[i] != 0) return false;
        return true;
    }
}