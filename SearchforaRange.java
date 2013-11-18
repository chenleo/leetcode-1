/**
 * Search for a Range
 * Given a sorted array of integers, find the starting and ending position
 * of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * http://oj.leetcode.com/problems/search-for-a-range/
 */

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int low = 0, high = A.length - 1;
        int left = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (A[middle] == target) {
                if (middle == 0 || A[middle - 1] < target) {
                    left = middle;
                    break;
                }
                else high = middle - 1;
            }
            else if (A[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        
        low = 0;
        high = A.length - 1;
        int right = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (A[middle] == target) {
                if (middle == A.length - 1 || A[middle + 1] > target) {
                    right = middle;
                    break;
                }
                else low = middle + 1;
            }
            else if (A[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        
        int[] res = {left, right};
        return res;
        
    }
}
