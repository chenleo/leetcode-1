/**
 * Plus One
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * http://oj.leetcode.com/problems/plus-one/
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (digits.length == 0) return null; 
        
        int i = digits.length - 1;
        digits[i] += 1;
        int one = digits[i] / 10;
        digits[i] %= 10;
        
        i--;
        while (one == 1 && i >= 0) {
            digits[i] += one;
            one = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }
        
        if (one == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int j = 1; j< newDigits.length; j++)
                newDigits[j] = digits[j - 1];
            digits = newDigits;
        }
        return digits;
    }
}
