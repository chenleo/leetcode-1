/**
 * Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * http://oj.leetcode.com/problems/generate-parentheses/
 */

class ValidString {
    String string;
    int left;
    int right;
    
    public ValidString(String s, int l, int r) {
        this.string = s;
        this.left = l;
        this.right = r;
    }
    
    public ValidString addLeft() {
        return new ValidString(this.string + '(', this.left + 1, this.right);
        // this.left++;
        // this.sb.append('(');
    }
    
    public ValidString addRight() {
        return new ValidString(this.string + ')', this.left, this.right + 1);
        // this.right++;
        // this.sb.append(')');
    }
}

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ValidString> validStrings = new ArrayList<ValidString>();
        ArrayList<String> res = new ArrayList<String>();
        
        int i = 0;
        validStrings.add(new ValidString("", 0, 0));
    
        while (i <= 2 * n) {
            ArrayList<ValidString> newValidStrings = new ArrayList<ValidString>();
            for (ValidString vs : validStrings) {
                if (vs.left == n && vs.right == n) res.add(vs.string);
                else {
                    if (vs.left < n) newValidStrings.add(vs.addLeft());
                    if (vs.left > vs.right) newValidStrings.add(vs.addRight());
                }
            }
            validStrings = newValidStrings;
            i++;
        }

        return res;
    }
}
