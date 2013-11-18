/**
 * Integer to Roman
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://oj.leetcode.com/problems/integer-to-roman/
 */

public class Solution {
    public String intToRoman(int num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] r = {'I', 'V', 'X', 'L', 'C', 'D', 'M', ' ', ' '}; // num <= 4000, so no digit for 5 and 10 at 1000 scale

        StringBuffer res = new StringBuffer();;
        for (int i = 6, scale = 1000; i >= 0; i-= 2, scale /= 10) {
            int digit = num / scale;
            if (digit > 0) {
                char one = r[i], five = r[i+1], ten = r[i+2];
                if (digit <= 3) {
                    for (int j = 1; j <= digit; j++) {
                        res.append(one);
                    }
                }
                
                else if (digit == 4) {
                    res.append(one);
                    res.append(five);
                }
                
                else if (digit <= 8) {
                    res.append(five);
                    for (int j = 1; j <= digit - 5; j++) {
                        res.append(one);
                    }
                }
                
                else { // must be 9
                    res.append(one);
                    res.append(ten);
                }
                num %= scale;
            }
        }
        
        return res.toString();
    }
}
