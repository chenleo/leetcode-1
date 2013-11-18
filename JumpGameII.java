/**
 * Jump Game II
 * Given an array of non-negative integers, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of
 * jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
 * from index 0 to 1, then 3 steps to the last index.)
 * 
 * http://oj.leetcode.com/problems/jump-game-ii/
 */

public class Solution {
    public int jump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int res = 0, range = 0, curMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > range) {
                range = curMax;
                res++;
            }
            curMax = Math.max(curMax, i + A[i]);
        }
        
        return res;
    }
}
