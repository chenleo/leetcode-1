/**
* ZigZag Conversion
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
* 
* P   A   H   N
* A P L S I I G
* Y   I   R
* And then read line by line: "PAHNAPLSIIGYIR"
* Write the code that will take a string and make this conversion given a number of rows:
* 
* string convert(string text, int nRows);
* convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
* 
* http://oj.leetcode.com/problems/zigzag-conversion/
*/
public class Solution {
    public String convert(String s, int nRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (nRows == 1) return s;

        final int zigSize = 2 * nRows - 2;
        final int total = s.length();

        char[] res = new char[total];
        int i = 0, k;

        // first row
        for (k = 0; k < total; k += zigSize) {
            res[i++] = s.charAt(k);
        }
        
        // first row to second last row
        for (int row = 1; row < nRows - 1; row++) {
            int zigJump = 2 * (nRows - row - 1);
            for (k = row; k < total; k += zigSize) {
                res[i++] = s.charAt(k);
                if (k + zigJump < total) {
                    res[i++] = s.charAt(k + zigJump);
                }
            }
        }
        
        // last row
        for (k = nRows - 1; k < total; k += zigSize) {
            res[i++] = s.charAt(k);
        }
        
        return new String(res);
    }
}