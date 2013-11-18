/**
 * Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has
 * length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses
 * substring is "()()", which has length = 4.
 * 
 * http://oj.leetcode.com/problems/longest-valid-parentheses/
 */

public class Solution {
    public int longestValidParentheses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(count);
                count = 0;
            }
            else {
                if (!stack.empty()) {
                    int lastCount = stack.pop();
                    count++;
                    count += lastCount;
                    if (count > max) max = count;
                }
                else {
                    count = 0;
                }
            }
        }
        return max * 2;
    }
}
