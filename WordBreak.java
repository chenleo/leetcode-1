/**
 * Word Break 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * http://oj.leetcode.com/problems/word-break/
 */

public class Solution {
    private String s = null;
    private Set<String> dict = null;
    private Map<Integer, Boolean> cache = null;
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        this.s = s;
        this.dict = dict;
        this.cache = new HashMap<Integer, Boolean>();
        return wb(0);
    }
    
    private boolean wb(int low) {
        Integer key = new Integer(low);
        if (cache.containsKey(key)) return cache.get(key);

        boolean res = false;
        if (low == this.s.length()) {
            res = true;
        }
        else {
            for (int i = low; i < this.s.length(); i++) {
                String s = this.s.substring(low, i + 1);
                if (this.dict.contains(s)) {
                    boolean subRes = wb(i + 1);
                    if (subRes) {
                        res = true;
                        break;
                    }
                }
            }
        }
        this.cache.put(key, res);
        return res;
    }
}
