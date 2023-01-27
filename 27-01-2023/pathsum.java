/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return pathsum(root,targetSum,sum);
    }
    public boolean pathsum(TreeNode root, int ts, int s) {
        if(root == null) {
            return false;
        }
 
        if(root.left == null && root.right == null) {
            s = s + root.val;
            if(s == ts) {
                return true;
            }
        }
        return pathsum(root.left, ts , s + root.val) || pathsum(root.right, ts, s + root.val);
    }
}