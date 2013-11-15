/**
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in
 * T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there
 * will always be only one unique minimum window in S.
 * 
 * http://oj.leetcode.com/problems/minimum-window-substring/
 */

public class Solution {
    public String minWindow(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] need = new int[256]; // **important** use fixed length array to make statistics instead of hashmap
        for (int i = 0; i < T.length(); i++) need[T.charAt(i)]++;
        
        
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int[] found = new int[256];
        int foundCount = 0;
        while (j < S.length()) {
            while (j < S.length() && foundCount < T.length()) {
                if (need[S.charAt(j)] > 0) {
                    found[S.charAt(j)]++;
                    if (found[S.charAt(j)] <= need[S.charAt(j)]) foundCount++;
                }
                j++;
            }
            if (foundCount == T.length()) { // found a match
                while (foundCount == T.length()) {
                    if (need[S.charAt(i)] > 0) {
                        found[S.charAt(i)]--;
                        if (found[S.charAt(i)] < need[S.charAt(i)]) foundCount--;
                    }
                    i++;
                }
                if (min > j - i + 1) {
                    minIndex = i - 1;
                    min = j - i + 1;
                }
            }
        }
        return minIndex >= 0 ? S.substring(minIndex, minIndex + min) : "";
    }
}