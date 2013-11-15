/**
 * Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */

public class Solution {
    public boolean search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int low = 0, high = A.length - 1;
        while (low <= high) {
            while (low < high && A[low] == A[low + 1]) low++;
            while (high > low && A[high] == A[high - 1]) high--;
            if (low >= high) return A[low] == target; // **important** all are the same

            int middle = low + (high - low) / 2;
            if (A[middle] == target) return true;
            
            if (A[middle] < A[high]) {
                if (target < A[middle] || target > A[high]) high = middle - 1;
                else low = middle + 1;
            }
            else {
                if (target > A[middle] || target < A[low]) low = middle + 1;
                else high = middle - 1;
            }
            
        }
        return false;
    }
}