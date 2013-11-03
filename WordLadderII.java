/**
 * Word Ladder II
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * http://oj.leetcode.com/problems/word-ladder-ii/
 */

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        dict.add(end);
        
        HashMap<String, ArrayList<String>> nextStepsMap = new HashMap<String, ArrayList<String>>();

        HashSet<String> current = new HashSet<String>(); // **important** can not use arraylist here
        current.add(start);
        dict.remove(start);

        boolean found = false;
        int length = 0;
        while (current.size() > 0) {
            length++;
            HashSet<String> next = new HashSet<String>();
            for (String node: current) {
                if (node.equals(end)) found = true;

                else {
                    for (int i = 0; i< node.length(); i++) {
                        StringBuffer sb = new StringBuffer(node);
                        for (char j = 'a'; j <= 'z'; j++) {
                            if (j == sb.charAt(i)) continue;
                            sb.setCharAt(i, j); // **important** find neighbor this way
                            String s = sb.toString();
                            if(dict.contains(s)) {
                                next.add(s);
                                if (!nextStepsMap.containsKey(s))
                                    nextStepsMap.put(s, new ArrayList<String>());
                                nextStepsMap.get(s).add(node);
                            }
                        }
                    }
                }
            }
            if (found) break;
            for (String nextNode: next)
                dict.remove(nextNode);
            current = next;

        }

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (found) { // **important** if not found, return "empty"
            Stack<String> path = new Stack<String>();
            // **important**
            // we "can" also reconstruct the solutions from start (of course we need to change code before)
            // but it has much more "wrong paths" to go than from end
            // so reconstruct the solutions from end
            path.push(end);
            constructPaths(res, nextStepsMap, end, path);
        }
        return res;
    }
    
     private static void constructPaths(ArrayList<ArrayList<String>> res, HashMap<String, ArrayList<String>> nextStepsMap, String end, Stack<String> path) {
        if (nextStepsMap.containsKey(end)) {
            ArrayList<String> lastStepsList = nextStepsMap.get(end);
            for (String lastStep: lastStepsList) {
                path.push(lastStep);
                constructPaths(res, nextStepsMap, lastStep, path);
                path.pop();
            }
        }
        else {
            ArrayList<String> solution = new ArrayList<String>();
            for (String s: path) solution.add(0, s);
            res.add(solution);
        }
    }
}
