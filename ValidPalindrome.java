/**
 * Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * http://oj.leetcode.com/problems/valid-palindrome/
 */

public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while(!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && i < j) i++;
            while(!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)) && i < j) j--;
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
