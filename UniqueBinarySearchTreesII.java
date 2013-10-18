/**
* Unique Binary Search Trees II
* Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
* 
* For example,
* Given n = 3, your program should return all 5 unique BST's shown below.
* 
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*     /     /       \                 \
*    2     1         2                 3
* confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
* 
* 
* OJ's Binary Tree Serialization:
* The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
* 
* Here's an example:
*    1
*   / \
*  2   3
*     /
*    4
*     \
*      5
* The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
* 
* http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
 
 // **important** (anyway to use DP?)
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTreesLowHight(1, n);
    }
    
    public static ArrayList<TreeNode> generateTreesLowHight(int low, int high) {
        int n = high - low + 1;
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        
        if (n <= 0) {
            res.add(null);
        }
        else if ( n == 1) {
            res.add(new TreeNode(low));
        }
        else {
            for (int j = low; j <= high; j++) {
                ArrayList<TreeNode> left = generateTreesLowHight(low, j - 1);
                ArrayList<TreeNode> right = generateTreesLowHight(j + 1, high);
                for (int k = 0; k < left.size(); k++) {
                    for (int h = 0; h < right.size(); h++) {
                        TreeNode root = new TreeNode(j);
                        root.left = left.get(k);
                        root.right = right.get(h);
                        res.add(root);
                    }
                }   
            }
        }
        return res;
    }
}