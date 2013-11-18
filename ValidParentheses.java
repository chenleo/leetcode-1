/**
 * Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 * 
 * http://oj.leetcode.com/problems/valid-parentheses/
 */

public class Solution {
    public boolean isValid(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Stack<Character> stack = new Stack<Character>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (!stack.empty() && match(stack.pop(), c));
                else return false;
            }
            else return false;
        }
        return stack.empty();
    }
    
    private static boolean match(char c1, char c2) {
        if (c1 == '(') return c2 == ')';
        if (c1 == '[') return c2 == ']';
        if (c1 == '{') return c2 == '}';
        return false;
    }
}
