/**
* Remove Element
* Given an array and a value, remove all instances of that value in place and return the new length.
* 
* The order of elements can be changed. It doesn't matter what you leave beyond the new length.
* 
* http://oj.leetcode.com/problems/remove-element/
*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int i = A.length - 1, j = i;
        while (i >= 0) {
            while (i >= 0 /**important**/&& A[i] != elem) { 
                i--;
            }
            if (i < 0) break;
            int temp = A[i];
            A[i] = A[j];
            A[j] = A[i];
            i--;
            j--;
        }
        return j + 1;
    }
}