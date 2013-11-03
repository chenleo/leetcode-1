/**
* String to Integer (atoi)
* Implement atoi to convert a string to an integer.
* 
* Hint: Carefully consider all possible input cases.
* 
* If you want a challenge, please do not see below and ask yourself what are the possible input cases.
* 
* Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
* 
* You are responsible to gather all the input requirements up front.
* 
* spoilers alert... click to show requirements for atoi.
* 
* Requirements for atoi:
* The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
* 
* Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
* 
* and interprets them as a numerical value.
* 
* The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
* 
* If the first sequence of non-whitespace characters in str is not a valid integral number,
* 
* or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
* 
* If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values,
* 
* INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*
* http://oj.leetcode.com/problems/string-to-integer-atoi/
*/
public class Solution {
    public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int total = str.length();
        int i = 0;
        while (i < total && Character.isWhitespace(str.charAt(i))) i++;
        if (i == total) return 0;
        
        int sign;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        else {
            sign = 1;
        }
        
        int digit, num = 0;
        while (i < total) {
            digit = str.charAt(i) - '0';
            if (digit >= 0 && digit <= 9) {
                if ((num > 214748364 || (num == 214748364 && digit > 7)) && sign == 1) return Integer.MAX_VALUE;
                if ((num > 214748364 || (num == 214748364 && digit > 8)) && sign == -1) return Integer.MIN_VALUE;
                num *= 10;
                num += digit;
                i++;
            }
            else break;
        }
        
        return num * sign;
    }
}