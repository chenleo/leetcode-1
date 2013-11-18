/**
 * Divide Two Integers
 * Divide two integers without using multiplication, division
 * and mod operator.
 * 
 * http://oj.leetcode.com/problems/divide-two-integers/
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        // **important** while transfer negative x to -x may cause overflow, transfer positive x to -x is safe
        // **important** so we transfer both dividend and divisor to negative values

        int sign = 1;
        if (dividend > 0) {
            sign = -sign;
            dividend = -dividend;
        }
        if (divisor > 0) {
            sign = -sign;
            divisor = -divisor;
        }
        
        int rest = dividend;
        int res = 0;
        
        while (rest <= divisor) {
            int fac = 1;
            int newDivisor = divisor;
            while (rest - newDivisor <= newDivisor) {
                newDivisor += newDivisor;
                fac += fac;
            }
            rest -= newDivisor;
            res += fac;
        }
        
        return sign * res;
    }
}
