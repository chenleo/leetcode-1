/**
* Maximum Subarray
* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
* 
* For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
* the contiguous subarray [4,−1,2,1] has the largest sum = 6.
* 
* click to show more practice.
* 
* More practice:
* If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
* 
* http://oj.leetcode.com/problems/maximum-subarray/
*/
public class Solution {
    public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) return 0;
        int max = A[0]; // **important**
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}