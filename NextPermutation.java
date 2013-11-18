/**
 * Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * http://oj.leetcode.com/problems/next-permutation/
 */

public class Solution {
    public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean largest = true;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                largest = false;
                for (int j = num.length - 1; j >= i; j--) {
                    if (num[j] > num[i - 1]) {
                        int temp = num[i - 1];
                        num[i - 1] = num[j];
                        num[j] = temp;
                        for (int h = i, k = num.length - 1; h < k; h++, k--) {
                            temp = num[h];
                            num[h] = num[k];
                            num[k] = temp;
                        }
                        break;
                    }
                }
                break;
            }
        }
        
        if (largest) {
            for (int i = 0, j = num.length - 1; i < j; i++, j--) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
    }
}
