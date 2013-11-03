/**
 * Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * 
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (prices.length == 0) return 0;
        int low = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int newProfit = prices[i] - low;
            if (newProfit > profit) profit = newProfit;
            if (low > prices[i]) low = prices[i];
        }
        return profit;
    }
}
