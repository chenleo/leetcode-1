/*
 * Palindrome Partitioning II
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * http://oj.leetcode.com/problems/palindrome-partitioning-ii/
 */

public class Solution {
    public int minCut(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = s.length();
        if (n == 0) return 0;

        int[] parts = new int[n + 1];
        for (int i = 0; i <= n; i++) parts[i] = n - i; // upper bound
        
        boolean[] lastIsP = new boolean[1];
        lastIsP[0] = true;
        
        // the last one is fixed, it's 1
        for (int i = n - 2; i >= 0; i--) {
            boolean[] newIsP = new boolean[n - i];
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(i) == s.charAt(i + j) && (j < 2 || lastIsP[j - 2])) {
                    newIsP[j] = true;
                    parts[i] = Math.min(parts[i], 1 + parts[i + j + 1]);
                }
                else newIsP[j] = false;
            }
            lastIsP = newIsP;
        }

        return parts[0] - 1;
    }
}
