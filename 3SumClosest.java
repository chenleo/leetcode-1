/**
 * 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the
 * sum is closest to a given number, target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * http://oj.leetcode.com/problems/3sum-closest/
 */

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below                                                                                                                                  
        // DO NOT write main() function                                                                                                                                           
        Arrays.sort(num);
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {
            int newTarget = target - num[i];

            int j = i + 1, k = num.length - 1;
            while (j < k) {
                int sum = num[j] + num[k];
                if (sum == newTarget) return target;

                if (
                    (res == Integer.MIN_VALUE && target == 0) /* **important** */||
                    Math.abs(res - target) > Math.abs(sum - newTarget)
                   ) {
                    res = sum + num[i];
                }
                if (sum < newTarget) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return res;
    }
}
