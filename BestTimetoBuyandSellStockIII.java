/**
 * Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (prices.length == 0) return 0;

        int[] first = new int[prices.length];
        
        int smallest = prices[0];
        int maxProfit = 0;
        first[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - smallest;
            if (diff > maxProfit) maxProfit = diff;
            first[i] = maxProfit;
            if (prices[i] < smallest) smallest = prices[i];
        }
        
        int p = 0;
        int largest = prices[prices.length - 1];
        maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int diff = largest - prices[i];
            if (maxProfit < diff) maxProfit = diff;
            if (prices[i] > largest) largest = prices[i];
            if (maxProfit + first[i] > p) p = maxProfit + first[i];
        }
        
        return p;
    }
}
