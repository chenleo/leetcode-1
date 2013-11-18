/**
 * Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * http://oj.leetcode.com/problems/jump-game/
 */

public class Solution {
    public boolean canJump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int range = 0, curMax = -1;
        for (int i = 0; i < A.length; i++) {
            if (i > range) {
                if (curMax <= range) return false;
                range = curMax;
            }
            curMax = Math.max(curMax, i + A[i]);
        }
        
        return true;
    }
}
