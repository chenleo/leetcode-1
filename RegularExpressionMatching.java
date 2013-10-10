/**
* Regular Expression Matching 
* Implement regular expression matching with support for '.' and '*'.
* 
* '.' Matches any single character.
* '*' Matches zero or more of the preceding element.
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
* isMatch("aa", "a*") → true
* isMatch("aa", ".*") → true
* isMatch("ab", ".*") → true
* isMatch("aab", "c*a*b") → true
* 
* http://oj.leetcode.com/problems/regular-expression-matching/
*/
public class Practice {
    public static boolean isMatch(String s, String p) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s == null || p == null) return false;
        return match(s, 0, p, 0);
    }
    
    private static boolean match(String s, int ss, String p, int sp) {
        // if (sp > p.length()) return false; // works both with and without this line

        if (sp == p.length()) return ss == s.length();
        
        if (sp + 1 < p.length() && p.charAt(sp + 1) == '*') {
            if (match(s, ss, p, sp + 2)) return true; // **important**
            while (ss < s.length()) {
                if ((s.charAt(ss) == p.charAt(sp) || p.charAt(sp) == '.')) { // **important**
                    ss++;                                                    // **important**
                    if (match(s, ss, p, sp + 2)) return true;                // **important**
                }                                                            // **important**
                else return false;                                           // **important**
            }
            return false;
        }
        else {
            if (ss < s.length()) {
                return (p.charAt(sp) == s.charAt(ss) || p.charAt(sp) == '.') && match(s, ss + 1, p, sp + 1);    
            }
            else {
                return false;
            }
            
        }
    }

     public static void main(String[] args) {
        if (isMatch(args[0], args[1])) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
        
    }
}