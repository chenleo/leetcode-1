/**
 * First Missing Positive
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * http://oj.leetcode.com/problems/first-missing-positive/
 */

public class Solution {
    public int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) A[i] = A.length + 2;
        }
        
        
        for (int i = 0; i < A.length; i++) {
            int index = Math.abs(A[i]);
            if (index > 0 && index <= A.length) A[index - 1] = -Math.abs(A[index - 1]);
        }
        
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) return i + 1;
        }
        
        return A.length + 1;
    }
}
