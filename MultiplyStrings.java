/**
 * Multiply Strings
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * http://oj.leetcode.com/problems/multiply-strings/
 */

public class Solution {
    public String multiply(String num1, String num2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        String res = "0";
        int n = num2.length();
        for (int i = 0; i < n; i++) {
            int d = num2.charAt(n - 1 - i) - '0';
            String thisRow = mulSingleDigit(num1, d, i);
            res = add(res, thisRow);
        }
        return res;
    }
    
    private String mulSingleDigit(String s, int d2, int zeroCount) {
        if (d2 == 0 || s.equals("0") ) return "0";
        
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < zeroCount; i++) res.append('0');

        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int d1 = s.charAt(i) - '0';
            int d = d1 * d2 + carry;
            carry = d / 10;
            d %= 10;
            res.append(d);
        }
        
        if (carry != 0) res.append(carry);
        
        return res.reverse().toString();
    }
    
    private String add(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        StringBuffer sb = new StringBuffer();
        int i = 1;
        int carry = 0;
        while (m - i >= 0 && n - i >= 0) {
            int d1 = s1.charAt(m - i) - '0';
            int d2 = s2.charAt(n - i) - '0';
            int d = d1 + d2 + carry;
            carry = d / 10;
            d %= 10;
            sb.append(d);
            i++;
        }
        while (m - i >= 0) {
            int d1 = s1.charAt(m - i) - '0';
            int d = d1 + carry;
            carry = d / 10;
            d %= 10;
            sb.append(d);
            i++;
        }
        while (n - i >= 0) {
            int d2 = s2.charAt(n - i) - '0';
            int d = d2 + carry;
            carry = d / 10;
            d %= 10;
            sb.append(d);
            i++;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
