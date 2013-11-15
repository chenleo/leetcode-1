/**
 * Sort Colors
 * Given an array with n objects colored red, white or blue, sort them
 * so that objects of the same color are adjacent, with the colors in
 * the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * click to show follow up.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using 
 * counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * http://oj.leetcode.com/problems/sort-colors/
 */

public class Solution {
    public void sortColors(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0, j = -1, k = A.length - 1;
        while (k > j) {
            if (A[k] == 2) k--;
            else {
                j++;
                int temp = A[j];
                A[j] = A[k];
                A[k] = temp;
                if (A[j] == 0) {
                    temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                    i++;
                }
            }
        }
    }
}