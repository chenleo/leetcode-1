/**
 * Interleaving String
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * http://oj.leetcode.com/problems/interleaving-string/
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l3 != l1 + l2) return false;
        
        if (l1 == 0) {
            for (int i = 0; i < l3; i++) 
                if (s3.charAt(i) != s2.charAt(i)) return false;
            return true;
        }
        if (l2 == 0) {
            for (int i = 0; i < l3; i++) 
                if (s3.charAt(i) != s1.charAt(i)) return false;
            return true;
        }
        
        boolean[] last = new boolean[l1 + 1];

        int level = 0;
        last[0] = true;
        for (int i = 1; i <= l1; i++) {
            last[i] = last[i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        while (level < l2) {
            level++;
            boolean[] newRes = new boolean[l1 + 1];
            newRes[0] = last[0] && s2.charAt(level - 1) == s3.charAt(level - 1);
            for (int i = 1; i <= l1; i++) {
                newRes[i] = (newRes[i-1] && s1.charAt(i - 1) == s3.charAt(level + i - 1)) || (last[i] && s2.charAt(level - 1) == s3.charAt(level + i - 1));
            }
            last = newRes;
        }
        
        return last[l1];
    }
}¯