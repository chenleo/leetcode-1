/**
 * Subsets
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * http://oj.leetcode.com/problems/subsets/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(S);

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());

        for (int num: S) {
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
            
            for (ArrayList<Integer> solution: res) {
                ArrayList<Integer> newSolution = new ArrayList<Integer>(solution);
                newSolution.add(num);
                newRes.add(newSolution);
            }
            
            res.addAll(newRes);
        }
        
        return res;
    }
}
