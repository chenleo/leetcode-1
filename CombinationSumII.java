/**
 * Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending
 * order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * http://oj.leetcode.com/problems/combination-sum-ii/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(num);
        if (num.length == 0) return new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> parts = new ArrayList<Integer>();
        ArrayList<Integer> partsLength = new ArrayList<Integer>();
        int i = 0;
        while (i < num.length) {
            int cur = num[i];
            parts.add(cur);
            int j = i + 1;
            while (j < num.length && num[j] == num[i]) j++;
            partsLength.add(j - i);
            i = j;
        }
        
        return combi(parts, partsLength, 0, target);
    }
    
    private ArrayList<ArrayList<Integer>> combi(ArrayList<Integer> parts, ArrayList<Integer> partsLength, int from, int target) {
        ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();

        if (from == parts.size()) {
            if (target == 0)
                res.add(new ArrayList<Integer>());
        }
        else {
            int num = parts.get(from), length = partsLength.get(from);
            ArrayList<ArrayList<Integer>> subRes = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= length; i++) {
                int newTarget = target - i * num;
                if (newTarget < 0) break; // **important** 
                for (ArrayList<Integer> solution: combi(parts, partsLength, from + 1, newTarget)) {
                    for (int j = 0; j < i; j++) solution.add(0, num);
                    subRes.add(solution);
                }
            }
            res.addAll(subRes);
        }
        
        return res;
    }
}
