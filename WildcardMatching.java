/**
 * Wildcard Matching
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * http://oj.leetcode.com/problems/wildcard-matching/
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (p.length() == 0) return s.length() == 0;
        int sIndex = 0, pIndex = 0, pBackup = -1, sBackup = -1;
        while (sIndex < s.length()) {
            if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                while (pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
                if (pIndex == p.length()) return true;
                pBackup = pIndex;
                sBackup = sIndex;
            }
            else if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))){
                pIndex++;
                sIndex++;
            }
            else { // **important** if pIndex >= p.length() and sIndex < s.length(), it's not directly false, it need to check backup
                if (pBackup >= 0) {
                    pIndex = pBackup;
                    sIndex = ++sBackup; // **important** here should be sBackup + 1 instead of sIndex + 1
                }
                else return false;
            }
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
        return pIndex == p.length();
    }
}
