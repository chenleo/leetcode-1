/**
* Longest Substring Without Repeating Characters
* Given a string, find the length of the longest substring without repeating characters.
* For example, the longest substring without repeating letters for "abcabcbb" is "abc",
* which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*
* http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        final int charCount = 26;
        boolean[] had = new boolean[charCount];
        for (int i = 0; i < charCount; i++) {
            had[i] = false;
        }
        int i = 0, j = 0, max = 0;
        int length = s.length();
        while (j < length) {
            if (had[s.charAt(j) - 'a']) {
                max = Math.max(j - i, max);
                while (i < j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        i++;
                        break;
                    }
                    else {
                        had[s.charAt(i) - 'a'] = false;
                        i++;
                    }
                }
            }
            else {
                had[s.charAt(j) - 'a'] = true;
            }
            j++;
        }
        max = Math.max(j - i, max); // **important**
        return max;
    }
}