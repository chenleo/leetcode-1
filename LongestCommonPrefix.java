/**
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an
 * array of strings.
 * 
 * http://oj.leetcode.com/problems/longest-common-prefix/
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        StringBuffer res = new StringBuffer();
        
        if (strs.length == 0) return "";
        
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) return res.toString();
            }
            res.append(c);
        }
        
        return res.toString();
    }
}
