/**
 * Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * http://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return restore(s, 0, 4);
    }
    
    private ArrayList<String> restore(String s, int from, int count) {
        ArrayList<String> res = new ArrayList<String>();
        if (from + count > s.length()) ;
        else if (count == 1) {
            if (from >= s.length() - 3) {
                if (s.charAt(from) - '0' == 0) {
                    if (from == s.length() - 1)
                        res.add("0");
                }
                else {
                    int ip = 0;
                    for (int i = from; i < s.length(); i++) {
                        int digit = s.charAt(i) - '0';
                        if (digit >= 0 && digit <= 9)
                            ip = ip * 10 + digit;
                        else {
                            ip = 256;
                            break;
                        }
                    }
                    if (ip <= 255) {
                        res.add(ip + "");
                    }
                }
            }
        }
        else {
            if (s.charAt(from) == '0') {
                int ip = 0;
                ArrayList<String> newSolutions = new ArrayList<String>();
                ArrayList<String> subRes = restore(s, from + 1, count - 1);
                for (String solution: subRes) {
                    newSolutions.add(ip + "." + solution);
                }
                res.addAll(newSolutions);
            }
            else {
                int ip = 0;
                for (int i = from; i <= from + 2 && i < s.length(); i++) {
                    int digit = s.charAt(i) - '0';
                    if (digit >= 0 && digit <= 9)
                        ip = ip * 10 + digit;
                    else ip = 256;
                    if (ip <= 255) {
                        ArrayList<String> newSolutions = new ArrayList<String>();
                        ArrayList<String> subRes = restore(s, i + 1, count - 1);
                        for (String solution: subRes) {
                            newSolutions.add(ip + "." + solution);
                        }
                        res.addAll(newSolutions);
                    }
                    else break;
                }
            }
        }
        return res;
    }
}