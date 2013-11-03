/**
 * Word Ladder
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * http://oj.leetcode.com/problems/word-ladder/
 */

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = 1;
        if (start == end) return length;
        
        dict.add(end);

        HashSet<String> visited = new HashSet<String>();

        ArrayList<String> current = new ArrayList<String>();
        current.add(start);
        visited.add(start);

        while (current.size() > 0) {
            ArrayList<String> next = new ArrayList<String>();
            for (String node: current) {
                if (node.equals(end)) return length;
                for (int i = 0; i< node.length(); i++) {
                    StringBuffer sb = new StringBuffer(node);
                    for (int j = 0; j < 26; j++) {
                        sb.setCharAt(i, (char)('a' + j)); // **important** find neighbor this way
                        String s = sb.toString();
                        if(dict.contains(s) && !visited.contains(s)) {
                            next.add(s);
                            visited.add(s);
                        }
                    }
                }
            }
            current = next;
            length++;
        }
        return 0;
    }
}
