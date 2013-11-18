/**
 * Search in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class Solution {
    public int search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (A[middle] == target) return middle;
            
            if (A[middle] < A[high]) {
                if (target < A[middle] || target > A[high]) high = middle - 1;
                else low = middle + 1;
            }
            else {
                if (target > A[middle] || target < A[low]) low = middle + 1;
                else high = middle - 1;
            }
        }
        return -1;
    }
}
