/**
 * Count and Say
 * The count-and-say sequence is the sequence of integers beginning as
 * follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * http://oj.leetcode.com/problems/count-and-say/
 */

public class Solution {
    public String countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) return null;
        
        int i = 1;
        String res = "1";
        
        while (i < n) {
            ArrayList<Character> parts = new ArrayList<Character>();
            ArrayList<Integer> partsLength = new ArrayList<Integer>();
            int j = 0;
            while (j < res.length()) {
                char cur = res.charAt(j);
                parts.add(cur);
                int end = j + 1;
                while (end < res.length() && res.charAt(end) == cur) end++;
                partsLength.add(end - j);
                j = end;
            }
            StringBuffer resBuffer = new StringBuffer();
            for (j = 0; j < parts.size(); j++) {
                resBuffer.append(partsLength.get(j));
                resBuffer.append(parts.get(j));
            }
            res = resBuffer.toString();
            i++;
        }
        
        return res;
    }
}
