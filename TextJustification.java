/**
 * Text Justification 
 * Given an array of words and a length L, format the text such that each 
 * line has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many
 * words as you can in each line. Pad extra spaces ' ' when necessary so 
 * that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots 
 * on the right.
 * 
 * For the last line of text, it should be left justified and no extra
 * space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * A line other than the last line might contain only one word. What
 * should you do in this case?
 * In this case, that line should be left-justified.
 * 
 * http://oj.leetcode.com/problems/text-justification/
 */

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> res = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {
            int count = 0;
            ArrayList<String> line = new ArrayList<String>();
            while (i < words.length && (count + words[i].length() <= L)) {
                line.add(words[i]);
                count += words[i].length() + 1;
                i++;
            }
            count--; // after last word there is no space
            if (i == words.length) {
                // last row
                for (int k = 0, l = line.size() - 1; k < l; k++)
                    line.add(2 * k + 1, nSpaces(1));
                line.add(nSpaces(L - count));
            }
            else if (line.size() == 1) {
                // just one word
                line.add(nSpaces(L - count));
            }
            else {
                int spacesLength = (L - count) / (line.size() - 1) + 1;
                int rest = (L - count) % (line.size() - 1);

                for (int k = 0, l = line.size() - 1; k < l; k++) {
                    line.add(2 * k + 1, nSpaces(spacesLength));
                }
                for (int k = 0; k < rest; k++) {
                    line.set(2 * k + 1, nSpaces(spacesLength + 1));
                }
            }
            res.add(join(line));
        }
        return res;
    }
    
    private String nSpaces(int n) {
        return new String(new char[n]).replace('\0', ' ');
    }
    
    private String join(ArrayList<String> line) {
        String res = "";
        for (String w: line) res += w;
        return res;
    }
}
