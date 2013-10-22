/**
* Roman to Integer
* Given a roman numeral, convert it to an integer.
* 
* Input is guaranteed to be within the range from 1 to 3999.
* 
* http://oj.leetcode.com/problems/roman-to-integer/
*/

public class Solution {
    public int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int res = 0;
        if (s.length() == 0) return res;

        int last = ctoi(s.charAt(0));
        res += last;

        for (int i = 1; i < s.length(); i++) {
            int cur = ctoi(s.charAt(i));
            if (last < cur) {
                res = res - last + (cur - last);
            }
            else {
                res += cur;
            }
            last = cur;
        }
        
        return res;
    }
    
    public static int ctoi(char c) {
        switch(c) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;
        }
    }
} 