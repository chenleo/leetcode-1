/**
* Unique Binary Search Trees
* Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
* 
* For example,
* Given n = 3, there are a total of 5 unique BST's.
* 
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*     /     /       \                 \
*    2     1         2                 3
* 
* http://oj.leetcode.com/problems/unique-binary-search-trees/
*/

public class Solution {
    public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] res = new int[n+1]; // **important** (n instead of n+1)
        res[0] = 1;
        res[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            res[i] = 0;
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        
        return res[n];
    }
}