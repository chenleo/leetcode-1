/**
 * Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * http://oj.leetcode.com/problems/combinations/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (k <= 0 || k > n) return new ArrayList<ArrayList<Integer>>();
        return combi(n, 1, k);
    }
    
    private ArrayList<ArrayList<Integer>> combi(int n, int s, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i = s; i <= n; i++) {
                ArrayList<Integer> solution = new ArrayList<Integer>();
                solution.add(i);
                res.add(solution);
            }
        }
        else if (s + k == n + 1) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            for (int i = s; i <= n; i++)
                solution.add(i);
            res.add(solution);
        }
        else {
            for (int i = s; i <= n + 1 - k; i++) {
                ArrayList<ArrayList<Integer>> tailres = combi(n, i + 1, k - 1);
                for (ArrayList<Integer> solution: tailres) {
                    solution.add(0, i);
                    res.add(solution);
                }
            }
        }
        
        return res;
    }
}
