/**
* Valid Number
* Validate if a given string is numeric.
* 
* Some examples:
* "0" => true
* " 0.1 " => true
* "abc" => false
* "1 a" => false
* "2e10" => true
* Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
* 
* http://oj.leetcode.com/problems/valid-number/
*/

public class Solution {
    public boolean isNumber(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int start = 0;
        int end = s.length() - 1;
        if (end < 0) return false;

        while(start < s.length() && s.charAt(start) == ' ') start++;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if (start > end) return false;
    
        if (start == end) {
            int digit = s.charAt(start) - '0';
            if (digit >= 0 && digit <= 9) return true;
            else return false;
        }
        
        if (s.charAt(start) == '-' || s.charAt(start) == '+') start++;

        boolean seenDot = false;
        boolean seenE = false;
        boolean seenDigit = false;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            if (digit < 0 || digit > 9) {
                if (seenDigit == true && seenE == false && (c == 'e' || c == 'E')) {
                    if (i < end) {
                        char nextChar = s.charAt(i+1);
                        if (nextChar == '+' || nextChar == '-') {
                            if (i+ 1 >= end) return false;
                            nextChar = s.charAt(i+2);
                            i++;
                        }
                        int nextDigit = nextChar - '0';
                        if (nextDigit >= 0 && nextDigit <= 9) {
                            seenE = true;
                            continue;
                        }
                    }
                }
                if (seenE == false && seenDot == false && (c == '.')) {
                    if (i < end) {
                        int nextDigit = s.charAt(i + 1) - '0';
                        if (nextDigit >= 0 && nextDigit <= 9) {
                            seenDot = true;
                            continue;
                        }
                    }
                    
                    if (seenDigit == true) {
                        seenDot = true;
                        continue;
                    }
                }
                return false;
            }
            else {
                seenDigit = true;
            }
        }
        return true;
    }
}