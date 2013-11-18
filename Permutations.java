/**
 * Permutations
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * http://oj.leetcode.com/problems/permutations/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return helper_permute(num, 0);
    }
    private ArrayList<ArrayList<Integer>> helper_permute(int[] num, int from) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (from >= num.length) {
            ArrayList<Integer> empty = new ArrayList<Integer>();
            res.add(empty);
        }
        else {
            ArrayList<ArrayList<Integer>> subRes = helper_permute(num, from + 1);
            int n = num[from];
            for (ArrayList<Integer> s: subRes) {
                for (int i = 0; i <= s.size(); i++) {
                    ArrayList<Integer> newS = new ArrayList<Integer>(s);
                    newS.add(i, new Integer(n));
                    res.add(newS);
                }
            }
        }
        return res;
    }
}
