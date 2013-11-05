/**
 * Merge Sorted Array
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * http://oj.leetcode.com/problems/merge-sorted-array/
 */

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int k = A.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n])
                A[k--] = A[m--];
            else A[k--] = B[n--];
        }
        
        while (n >= 0) {
            A[k--] = B[n--];
        }
    }
}