/**
* Single Number II
* Given an array of integers, every element appears three times except for one. Find that single one.
* 
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* 
* http://oj.leetcode.com/problems/single-number-ii/
*/

public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] occur = new int[33];
        for (int i = 0; i < A.length; i++) {
            int n = A[i];

            if (n < 0) { // **important**
                occur[32] += 1;
                n = -n;
            }

            for (int j = 0; j < 32; j++) {
                occur[j] += (n >> j) & 1;
            }

            for (int j = 0; j < 33; j++) { // **important**
                occur[j] %= 3;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (occur[i] << i);
        }

        return occur[32] == 0 ? res : -res;
    }
}