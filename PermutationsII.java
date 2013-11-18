/**
 * Permutations II
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * http://oj.leetcode.com/problems/permutations-ii/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        boolean[] used = new boolean[num.length];
        for (int i = 0; i < num.length; i++) used[i] = false; 
        
        go(res, num, new ArrayList<Integer>(), used);
        
        return res;
    }
    
    private void go(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> path, boolean[] used) {
        if (path.size() == num.length) res.add(new ArrayList<Integer>(path));
        else {
            for (int i = 0; i < num.length; i++) {
                if (!used[i] && (i == 0 || num[i] != num[i-1] || used[i - 1])) {
                    path.add(num[i]);
                    used[i] = true;
                    go(res, num, path, used);
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
