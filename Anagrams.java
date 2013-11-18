/**
 * Anagrams
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * http://oj.leetcode.com/problems/anagrams/
 */

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            String s = sorted(strs[i]);
            if (map.containsKey(s)) {
                if (map.get(s) != -1) {
                    res.add(strs[map.get(s)]);
                    map.put(s, -1);
                }
                res.add(strs[i]);
            }
            else map.put(s, i);
        }
        
        return res;
    }
    
    private String sorted(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
