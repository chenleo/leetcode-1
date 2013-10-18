/**
* Container With Most Water
* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
* 
* n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
* 
* Find two lines, which together with x-axis forms a container, such that the container contains the most water.
* 
* Note: You may not slant the container.
* 
* http://oj.leetcode.com/problems/container-with-most-water/
*/

public class Solution {
    public int maxArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int max = 0;
        int i = 0, j = height.length - 1;
        int area;
        while (i < j) {
            if (height[i] < height[j]) {
                area = height[i] * (j - i);
                i++;
            }
            else {
                area = height[j] * (j - i);
                j--;
            }
            if (area > max) max = area;
        }
        return max;
    }
}