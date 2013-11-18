/**
 * Pow(x, n)
 * Implement pow(x, n).
 * 
 * http://oj.leetcode.com/problems/powx-n/
 */

public class Solution {
    public double pow(double x, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n < 0) {
            if (n == Integer.MIN_VALUE) return 1 / pow(x, -(n + 1)) / x;
            return 1 / pow(x, -n);
        }
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) return pow(x * x, n / 2);
        return x * pow(x * x, (n - 1) / 2);
    }
}
