/**
 * 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets in the
 * array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 * http://oj.leetcode.com/problems/4sum/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set set = new HashSet();
        int low = 0, high = num.length - 1;
        for (int i = low; i <= high - 3; i++) {
            for (ArrayList<Integer> r : threeSum(num, target - num[i], i + 1, high)) {
                r.add(0, num[i]);
                if (set.add(r)) {
                    res.add(r);
                }
            }
        }
        return res;
    }
    
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target, int low, int high) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set set = new HashSet();

        for (int i = low; i <= high - 2; i++) {
            for (ArrayList<Integer> r : twoSum(num, target - num[i], i + 1, high)) {
                r.add(0, num[i]);
                if (set.add(r)) {
                    res.add(r);
                }
            }
        }
        return res;
    }
    
    public static ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int low, int high) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        while (low < high) {
            int sum = num[low] + num[high];
            if (sum > target) high--;
            else if (sum == target) {
                ArrayList<Integer> ans = new ArrayList<Integer>();
                ans.add(num[low]);
                ans.add(num[high]);
                res.add(ans);
                low++;
                high--;
            }
            else low++;
        }
        return res;
    }
}
