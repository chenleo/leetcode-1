/**
 * Word Break II
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * http://oj.leetcode.com/problems/word-break-ii/ 
 */


public class Solution {
    private String s = null;
    private Set<String> dict = null;
    private Map<Integer, ArrayList<String>> cache = null;
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        this.s = s;
        this.dict = dict;
        this.cache = new HashMap<Integer, ArrayList<String>>();
        return wb(0);
    }
    
    private ArrayList<String> wb(int low) {
        Integer key = new Integer(low);
        if (cache.containsKey(key)) return cache.get(key);

        ArrayList<String> res = new ArrayList<String>();
        if (low == this.s.length()) {
            res.add("");
        }
        else {
            for (int i = low; i < this.s.length(); i++) {
                String s = this.s.substring(low, i + 1);
                if (this.dict.contains(s)) {
                    ArrayList<String> subRes = wb(i + 1);
                    for (String ss: subRes) {
                        if (ss == "") {
                            res.add(s);
                        }
                        else {
                            res.add(s + " " + ss);       
                        }
                    }
                }
            }
        }
        this.cache.put(key, res);
        return res;
    }
}
