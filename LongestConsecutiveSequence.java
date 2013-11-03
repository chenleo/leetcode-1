/**
 * Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * http://oj.leetcode.com/problems/longest-consecutive-sequence/
 */

public class Solution {
    public int longestConsecutive(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<Integer, Boolean> record = new HashMap<Integer, Boolean>();
        for (int n: num) record.put(n, true);
        int max = 0;
        for (int n: num) {
            if (record.containsKey(n)) {
                int c = 1;
                int i = 1;
                while (record.containsKey(n - i)) {
                    record.remove(n - i);
                    c++;
                    i++;
                }
                i = 1;
                while (record.containsKey(n + i)) {
                    record.remove(n + i);
                    c++;
                    i++;
                }
                if (c > max) max = c;
            }
        }
        return max;
    }
}
