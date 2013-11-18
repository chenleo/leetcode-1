/**
 * Length of Last Word
 * Given a string s consists of upper/lower-case alphabets
 * and empty space characters ' ', return the length of last 
 * word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists
 * of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * http://oj.leetcode.com/problems/length-of-last-word/
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int count = 0;
        boolean inCount = true; // **important**
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c ==' ') {
                inCount = false;
            }
            else if (inCount) {
                count++;
            }
            else {
                inCount = true;
                count = 1;
            }
        }
        
        return count;
    }
}

// public class Solution {
//     public int lengthOfLastWord(String s) {
//         // IMPORTANT: Please reset any member data you declared, as
//         // the same Solution instance will be reused for each test case.
//         int i = s.length() - 1;
//         while (i >= 0 && s.charAt(i) == ' ') i--;
//         if (i == -1) return 0;
//         int j = i;
//         while (j >= 0 && s.charAt(j) != ' ') j--;
//         return i - j;
//     }
// }