/**
 * Add Binary 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * http://oj.leetcode.com/problems/add-binary/
 */

public class Solution {
    public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = a.length(), n = b.length();
        if (m > n) {
            int diff = m - n;
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < diff; i++) s.append('0');
            s.append(b);
            b = s.toString();
        }
        else if (m < n) {
            int diff = n - m;
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < diff; i++) s.append('0');
            s.append(a);
            a = s.toString();
        }
        
        StringBuffer res = new StringBuffer();
        int plusOne = 0;
        for (int i = Math.max(m, n) - 1; i >= 0; i--) {
            int d1 = a.charAt(i) - '0', d2 = b.charAt(i) - '0';
            int d = d1 + d2 + plusOne;
            plusOne = d / 2;
            d %= 2;
            res.insert(0, d);
        }
        if (plusOne == 1) res.insert(0, 1);
        return res.toString();
    }
}