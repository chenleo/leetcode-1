/**
* 3Sum
* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
* 
* Note:
* Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
* The solution set must not contain duplicate triplets.
*     For example, given array S = {-1 0 1 2 -1 -4},
* 
*     A solution set is:
*     (-1, 0, 1)
*     (-1, -1, 2)
*
* http://oj.leetcode.com/problems/3sum/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Set set = new HashSet();

        Arrays.sort(num);
        int end = num.length - 1;
        for (int i = 0; i <= end; i++) {
            int target = -num[i];
            int j = i + 1, k = end;
            while (j < k) {
                int sum = num[j] + num[k];
                if (sum > target) k--;
                else if (sum < target) j++;
                else { // found an answer
                    ArrayList<Integer> answer = new ArrayList<Integer>();
                    answer.add(num[i]);
                    answer.add(num[j]);
                    answer.add(num[k]);
                    if (set.add(answer))
                        results.add(answer);
                    j++;
                    k--;
                }
            }
        }
        return results;
    }
}