/**
* Search Insert Position
* Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
* 
* You may assume no duplicates in the array.
* 
* Here are few examples.
* [1,3,5,6], 5 → 2
* [1,3,5,6], 2 → 1
* [1,3,5,6], 7 → 4
* [1,3,5,6], 0 → 0
* 
* http://oj.leetcode.com/problems/search-insert-position/
*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (target <= A[0]) return 0;
        if (target > A[A.length - 1]) return A.length; // **important** (> instead of >=)
        
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (A[middle] == target || (A[middle] > target && A[middle - 1] < target)) return middle;
            else if (A[middle] > target) high = middle - 1;
            else low = middle + 1;
        }
        return -1;
    }
}