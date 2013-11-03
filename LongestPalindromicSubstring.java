/**
* Longest Palindromic Substring
* Given a string S, find the longest palindromic substring in S.
* You may assume that the maximum length of S is 1000,
* and there exists one unique longest palindromic substring.
*
* http://oj.leetcode.com/problems/longest-palindromic-substring/
*/
public class Solution {
    public String longestPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] t = new char[2 * s.length() + 1]; // **important** 2*length - 1 doesn't work
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '*';
            t[2 * i] = s.charAt(i);
        }
        t[t.length - 1] = '*';
        
        int[] p = new int[t.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }

        int c = 0, r = 0;
        for (int i = 0; i < t.length; i++) {
            int i_mirror = 2*c - i;
            if (i < c + r) {
                p[i] = Math.min(c + r - i, p[i_mirror]);
            }
            else {
                p[i] = 0;
            }
            
            while (i - p[i] - 1 >=0 && i + p[i] + 1 < t.length && t[i + p[i] + 1] == t[i - p[i] - 1]) {
                p[i]++;
            }
            
            if (i + p[i] > c + r) {
                c = i;
                r = p[i];
            }
        }
        
        c = 0; r = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > r) {
                c = i;
                r = p[i];
            }   
        }
        
        if (c % 2 == 0) {
            return s.substring(c/2 - r/2, c/2 + r/2 + 1);
        }
        else {
            r = (r + 1) / 2;
            return s.substring(c/2 - r + 1, c/2 + r + 1);
        }
    }
}