/**
 * Combination Sum
 * Given a set of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending
 * order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * http://oj.leetcode.com/problems/combination-sum/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(candidates);
        return combiSum(candidates, target, 0);
    }
    
    public static ArrayList<ArrayList<Integer>> combiSum(int[] a, int target, int minI) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            ArrayList<Integer> empty = new ArrayList<Integer>();
            res.add(empty);
        }
        else {
            for (int i = minI; i < a.length; i++) {
                int n = a[i];
                if (n > target) break;
                ArrayList<ArrayList<Integer>> subres = combiSum(a, target - n, i);
                for (ArrayList<Integer> sr : subres) {
                    sr.add(0, n);
                    res.add(sr);
                }
            }
        }
        return res;
    }
}
