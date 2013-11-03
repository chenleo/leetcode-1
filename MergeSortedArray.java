/**
* Merge Sorted Array
* Given two sorted integer arrays A and B, merge B into A as one sorted array.
* 
* Note:
* You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
* 
* http://oj.leetcode.com/problems/merge-sorted-array/
*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int i = m - 1;
        int j = n - 1;
        int k = A.length - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            }
            else {
                A[k--] = B[j--];
            }
        }
        
        while (i >=0 ) {
            A[k--] = A[i--];
        }
        
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}