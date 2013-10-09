/**
* Sqrt(x)
* Implement int sqrt(int x).
*
* Compute and return the square root of x.
*
* http://oj.leetcode.com/problems/sqrtx/
*/
public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        long r = 1; // **important**
        while (r * r < x) {
            r *= 2;
        }
        
        long l = r / 2, h = r, m = l;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (m * m > x) h = m - 1;
            else if ((m + 1) * (m + 1) <= x) l = m + 1;
            else break;
        }
        return (int)m;
    }
}