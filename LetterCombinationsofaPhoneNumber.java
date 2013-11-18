/**
 * Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is
 * given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could
 * be in any order you want.
 * 
 * http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class Solution {
    private static String[] mapping = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public ArrayList<String> letterCombinations(String digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> res = new ArrayList<String>();
        combi(digits, 0, res, new StringBuffer());
        return res;
    }
    
    private void combi(String digits, int low, ArrayList<String> res, StringBuffer path) {
        if (low == digits.length())
            res.add(path.toString());
        else {
            int digit = digits.charAt(low) - '0';
            String candidates = mapping[digit];
            for (int i = 0; i < candidates.length(); i++) {
                path.append(candidates.charAt(i));
                combi(digits, low + 1, res, path);
                path.setLength(path.length() - 1);
            }
        }
    }
}
