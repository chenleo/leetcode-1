/**
* Median of Two Sorted Arrays
* There are two sorted arrays A and B of size m and n respectively.
* Find the median of the two sorted arrays.
* The overall run time complexity should be O(log (m+n)).
*
* http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
*/
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int total = A.length + B.length;
        if (total % 2 == 1) {
            return kth(A, 0, A.length - 1, B, 0, B.length - 1, total / 2 + 1);
        }
        else {
            return (kth(A, 0, A.length - 1, B, 0, B.length - 1, total / 2) +
                kth(A, 0, A.length - 1, B, 0, B.length - 1, total / 2 + 1)) / 2;
        }
    }
    
    private double kth(int[] A, int la, int ra, int[] B, int lb, int rb, int k) {
        if (la > ra) return B[lb + k - 1];
        if (lb > rb) return A[la + k - 1];
        
        if (k == 1) return Math.min(A[la], B[lb]); // **important**
        
        int pa, pb;
        if (ra - la > rb - lb) {
            pb = Math.min(k/2, rb - lb + 1);
            pa = k - pb;
        }
        else {
            pa = Math.min(k/2, ra - la + 1);
            pb = k - pa;
        }
        
        if (A[la + pa - 1] > B[lb + pb - 1]) {
            return kth(A, la, ra, B, lb + pb, rb, k - pb);
        }
        else if (A[la + pa - 1] < B[lb + pb - 1]) {
            return kth(A, la + pa, ra, B, lb, rb, k - pa);
        }
        else {
            return A[la + pa - 1];
        }
    }
}