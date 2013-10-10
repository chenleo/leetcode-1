/**
* Candy
* There are N children standing in a line. Each child is assigned a rating value.
*
* You are giving candies to these children subjected to the following requirements:
*
* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.
* What is the minimum candies you must give?
*
* http://oj.leetcode.com/problems/candy/
*/

public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (ratings.length == 0) return 0;

        int[] candies = new int[ratings.length];

        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
            else {
                candies[i] = 1;
            }
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
            // **important**
            // else {
            //     candies[i] = 1;
            // }
        }
        
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
}