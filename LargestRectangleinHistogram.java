/**
 * Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 */

public class Solution {
    public int largestRectangleArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int res = 0;
        Stack<Integer> stack= new Stack<Integer>();
        
        // push a zero at the end
        int[] fakeHeight = new int[height.length + 1];
        for (int i = 0; i < height.length; i++) fakeHeight[i] = height[i];
        fakeHeight[height.length] = 0;
        
        
        int i = 0;
        while (i < fakeHeight.length) {
            if (stack.empty() || fakeHeight[i] >= fakeHeight[stack.peek()]) {
                stack.push(i++);
            }
            else {
                int h = fakeHeight[stack.pop()];
                // **important**, the width is not [the index of h: i]
                // it should be [the highest index in stack whose height smaller than h: i]
                int area = h * (i - (stack.empty() ? -1 : stack.peek()) - 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}