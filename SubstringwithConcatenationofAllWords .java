/**
 * Substring with Concatenation of All Words 
 * You are given a string, S, and a list of words, L, that are all of 
 * the same length. Find all starting indices of substring(s) in S that
 * is a concatenation of each word in L exactly once and without any
 * intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Map<String, Integer> wordsCountMap = new HashMap<String, Integer>();
        int wc = L.length;
        int wl = L[0].length();
        
        for (int i = 0; i < wc; i++)
            wordsCountMap.put(L[i], (wordsCountMap.containsKey(L[i]) ? wordsCountMap.get(L[i]) : 0) + 1);
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < S.length() - wc * wl + 1; i++) {
            Map<String, Integer> realWordsCountMap = new HashMap<String, Integer>();
            boolean found = true;
            for (int j = 0; j < wc; j++) {
                String sub = S.substring(i + j * wl, i + (j + 1) * wl);
                if (wordsCountMap.containsKey(sub)) {
                    if (realWordsCountMap.containsKey(sub)) {
                        int preOccured = realWordsCountMap.get(sub);
                        if (preOccured == wordsCountMap.get(sub)) {
                            found = false;
                            break;
                        }
                        else realWordsCountMap.put(sub, preOccured + 1);
                    }
                    else realWordsCountMap.put(sub, 1);
                }
                else {
                    found = false;
                    break;
                }
            }
            if (found) res.add(i);
        }
        
        return res;
    }
}
