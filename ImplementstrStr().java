/**
 * Implement strStr()
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle
 * in haystack, or null if needle is not part of haystack.
 * 
 * http://oj.leetcode.com/problems/implement-strstr/
 */

public class Solution {
    public String strStr(String haystack, String needle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // kmp
        int l1 = haystack.length(), l2 = needle.length();
        if (l2 == 0) return haystack;
        if (l1 < l2) return null;
        
        int[] pattern = buildPattern(needle);

        int j = 0, fc = 0;
        while(j < l1) { // **important** (< l1 instead of <= (l1 - l2))
            while (fc < l2 && j < l1 && needle.charAt(fc) == haystack.charAt(j)) {
                j++;
                fc += 1;
            }
            if (fc == l2) return haystack.substring(j - l2);
            if (j == l1) return null;
            while (fc > 0 && needle.charAt(fc) != haystack.charAt(j)) fc = pattern[fc - 1]; // **important** fc - 1 instead of fc
            if (needle.charAt(fc) == haystack.charAt(j)) fc++;
            j++;
        }
        return null;
    }
    
    private static int[] buildPattern(String needle) {
        int[] pattern = new int[needle.length()];
        pattern[0] = 0;
        
        for (int i = 1; i < needle.length(); i++) {
            int k = pattern[i - 1];
            while (k > 0 && needle.charAt(k) != needle.charAt(i)) {
                k = pattern[k - 1]; // **important** fc - 1 instead of fc
            }
            if (needle.charAt(k) == needle.charAt(i)) k++;
            pattern[i] = k;
        }
        
        return pattern;
    }
}
