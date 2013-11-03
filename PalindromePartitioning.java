/*
 * Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *  [
 *    ["aa","b"],
 *    ["a","a","b"]
 *  ]
 *
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 */

public class Solution {
    private ArrayList<ArrayList<String>> res = null;

    public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        res = new ArrayList<ArrayList<String>>();
        go(s, 0, new ArrayList<String>());
        return res;
    }
    
    private void go(String s, int from, ArrayList<String> path) {
        if (from == s.length()) {
            res.add(new ArrayList<String>(path));
        }
        else {
            for (int i = from; i < s.length(); i++) {
                if (isPalindrome(s, from, i)) {
                    path.add(s.substring(from, i + 1));
                    go(s, i + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from++) != s.charAt(to--)) return false;
        }
        return true;
    }
}
