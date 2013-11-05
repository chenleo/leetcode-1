/**
 * Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * http://oj.leetcode.com/problems/decode-ways/
 */

public class Solution {
    HashMap<Integer, Integer> map = null;
    public int numDecodings(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        map = new HashMap<Integer, Integer>();
        return go(s, 0);
    }
    
    private int go (String s, int from) {
        if (map.containsKey(from)) return map.get(from);
        int res = 0;
    
        if (from >= s.length()) res = 0;
        else if (from == s.length() - 1 && s.charAt(from) != '0') res = 1;
        else if (from == s.length() - 2){
            if (s.charAt(from) > '2') {
                if (s.charAt(from + 1) != '0') res = 1;
            }
            else {
                if (s.charAt(from) == '1') {
                    if (s.charAt(from + 1) == '0') res = 1;
                    else res = 2;
                }
                else if (s.charAt(from) == '2') {
                    if (s.charAt(from + 1) == '0' || s.charAt(from + 1) > '6') res = 1;
                    else res = 2;
                }
            }
        }
        else {
            if (s.charAt(from) != '0') res += go(s, from + 1);
            if (s.charAt(from) == '1') res += go(s, from + 2);
            if (s.charAt(from) == '2' && s.charAt(from + 1) <= '6') res += go(s, from + 2);
        }
        map.put(from, res);
        return res;
    }
}