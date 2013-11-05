/**
 * Subsets II
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * http://oj.leetcode.com/problems/subsets-ii/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (num.length == 0) return new ArrayList<ArrayList<Integer>>(); // empty

        Arrays.sort(num);

        ArrayList<Integer> parts = new ArrayList<Integer>();
        ArrayList<Integer> partsCount = new ArrayList<Integer>();
        int i = 0, cur;
        while (i < num.length) {
            cur = num[i];
            parts.add(cur);
            int count = 1;
            while (i + count < num.length && num[i + count] == cur) count++;
            partsCount.add(count);
            i += count;
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for (i = 0; i < parts.size(); i++) {
            int number = parts.get(i);
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> solution: res) {
                ArrayList<Integer> newSolution = new ArrayList<Integer>(solution);
                for (int count = 1; count <= partsCount.get(i); count++) {
                    newSolution.add(number);
                    newRes.add(new ArrayList<Integer>(newSolution));
                }
            }
            res.addAll(newRes);
        }
        
        return res;
    }
}