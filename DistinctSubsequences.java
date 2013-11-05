/**
 * Distinct Subsequences
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * http://oj.leetcode.com/problems/distinct-subsequences/
 */

public class Solution {
    public int numDistinct(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = S.length();
        if (m == 0) return 0;
        int n = T.length();
        if (n == 0) return 0;
        
        int[] last = new int[n];
        int sc = 1;
        last[0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
        for (int i = 1; i < n; i++) last[i] = 0;
        
        while (sc < m) {
            sc++;
            int[] cur = new int[n];
            cur[0] = last[0];
            if (S.charAt(sc - 1) == T.charAt(0)) cur[0]++;
            for (int i = 1; i < n; i++) {
                cur[i] = last[i];
                if (S.charAt(sc - 1) == T.charAt(i)) cur[i] += last[i - 1];
            }
            last = cur;
        }

        return last[n - 1];
    }
}