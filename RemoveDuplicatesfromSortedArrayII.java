/**
 * Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0) return 0;

        int count = 0, i = 0, cur;
        while (i < A.length) {
            cur = A[i];
            int j = i;
            while (j + 1 < A.length && A[j + 1] == cur) j++;
            if (j >= i) A[count++] = A[i];
            if (j >= i + 1) A[count++] = A[i];
            i = j + 1;
        }
        
        return count;
    }
}
