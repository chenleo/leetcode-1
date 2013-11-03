/**
* Remove Duplicates from Sorted Array
* Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
* 
* Do not allocate extra space for another array, you must do this in place with constant memory.
* 
* For example,
* Given input array A = [1,1,2],
* 
* Your function should return length = 2, and A is now [1,2].
* 
* http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) return 0;

        mergeSort(A, 0, A.length - 1);

        int cur = A[0];
        int i = 1;
        int k = 0;
        while (i < A.length) {
            while (i < A.length && A[i] == cur) {
                i++;
            }
            if (i < A.length) {
                k++;
                A[k] = A[i];
                cur = A[i];
                i++;
            }
        }
        return k + 1;
    }
    
    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int pivot = A[low];
            int i = low, j = high;
            while (i < j) {
                if (A[j] <= pivot) {
                    i++;
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
                else {
                    j--;
                }
            }
            A[low] = A[i];
            A[i] = pivot;
            mergeSort(A, low, i - 1);
            mergeSort(A, i + 1, high);
        }
    }
}