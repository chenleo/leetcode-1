/**
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the
 * width of each bar is 1, compute how much water it is able to trap after
 * raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * http://oj.leetcode.com/problems/trapping-rain-water/
 */

public class Solution {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int l = A.length;
        if (l == 0) return 0;
        
        int[] left = new int[l];
        int m = -1;
        for (int i = 0; i < l; i++) {
            if (A[i] > m) m = A[i];
            left[i] = m;
        }
        
        m = -1;
        int sum = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (A[i] > m) m = A[i];
            sum += (Math.min(m, left[i]) - A[i]);
        }

        return sum;
    }
}
