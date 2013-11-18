/**
 * Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * http://oj.leetcode.com/problems/simplify-path/
 */

public class Solution {
    public String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while (i < path.length()) {
            int end = i + 1;
            String comp = "";
            while (end < path.length() && path.charAt(end) != '/') {
                comp += path.charAt(end);
                end++;
            }
            if (comp.equals(".") || comp.equals(""));
            else if (comp.equals("..")) {
                if (!stack.empty()) stack.pop();
            }
            else {
                stack.push(comp);
            }
            i = end;
        }
        if (stack.empty()) return "/";
        String res = "";
        while (!stack.empty()) {
            res = '/' + stack.pop() + res;
        }
        return res;
    }
}