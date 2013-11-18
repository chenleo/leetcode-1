/**
 * Permutation Sequence
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * http://oj.leetcode.com/problems/permutation-sequence/
 */

public class Solution {
    public String getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = 1;
        for (int i = 1; i <= n - 1; i++) m *= i;
        
        StringBuffer res = new StringBuffer();
        
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) used[i] = false;

        int r = k;
        for (int i = n - 1; i >= 0; i--) {
            int nth = helper(r, m, used, res);
            r -= (nth - 1) * m;
            if (i > 0) m /= i;
        }
        
        return res.toString();
    }
    
    private int helper(int r, int m, boolean[] used, StringBuffer res) {
        int nth = (r - 1) / m + 1, count = nth;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) count--;
            if (count == 0) {
                used[i] = true;
                res.append(i + 1);
                break;
            }
        }
        return nth;
    }
}
