/**
* Two Sum
* Given an array of integers, find two numbers such that they add up to a specific target number.
* 
* The function twoSum should return indices of the two numbers such that they add up to the target,
* where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
* 
* You may assume that each input would have exactly one solution.
* 
* Input: numbers={2, 7, 11, 15}, target=9
* Output: index1=1, index2=2
*
* http://oj.leetcode.com/problems/two-sum/
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        
        int[] copy = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }
        Arrays.sort(copy);
        
        // find numbers
        int i = 0;
        int j = copy.length - 1;
        
        while (i < j) {
            int sum = copy[i] + copy[j];
            if (sum == target) {
                result[0] = copy[i];
                result[1] = copy[j];
                break;
            }
            else if (sum > target) {
                j--;
            }
            else {
                i++;
            }
        }
        
        // find indexes
        if (result[0] == result[1]) {
            for (i = 0; i < numbers.length; i++) {
                if (numbers[i] == result[0]) {
                    result[0] = i + 1;
                    for (j = i + 1; j < numbers.length; j++) {
                        if (numbers[j] == result[1]) {
                            result[1] = j + 1;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        else {
            for (i = 0; i < numbers.length; i++) {
                if (numbers[i] == result[0]) {
                    result[0] = i + 1;
                    break;
                }
            }
            for (i = 0; i < numbers.length; i++) {
                if (numbers[i] == result[1]) {
                    result[1] = i + 1;
                    break;
                }
            }
            if (result[0] > result[1]) {
                int temp = result[0];
                result[0] = result[1];
                result[1] = temp;
            }
        }
        return result;
    }
}