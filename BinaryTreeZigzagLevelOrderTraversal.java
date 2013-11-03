/**
* Binary Tree Zigzag Level Order Traversal
* Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
* 
* For example:
* Given binary tree {3,9,20,#,#,15,7},
*     3
*    / \
*   9  20
*     /  \
*    15   7
* return its zigzag level order traversal as:
* [
*   [3],
*   [20,9],
*   [15,7]
* ]
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
* http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return res;
        
        boolean reverse = true;
        
        ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);
        
        while (curLevel.size() > 0) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
    
            if (reverse == false) {
                for (int i = curLevel.size() - 1; i >= 0; i--) { // **important** (same order as reverse = true)
                    TreeNode node = curLevel.get(i);
                    if (node.left != null) nextLevel.add(node.left);
                    if (node.right != null) nextLevel.add(node.right);
                }
            }
            else {
                for (int i = curLevel.size() - 1; i >= 0; i--) {
                    TreeNode node = curLevel.get(i);
                    if (node.right != null) nextLevel.add(node.right);
                    if (node.left != null) nextLevel.add(node.left);
                }
            }
            res.add(nodesToVal(curLevel));
            curLevel = nextLevel;
            reverse = !reverse;
        }
        
        return res;
    }
    
    public static ArrayList<Integer> nodesToVal(ArrayList<TreeNode> nodes) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nodes.size(); i++) {
            res.add(nodes.get(i).val);
        }
        return res;
    }
}