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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null && curr.val != key) {
            prev = curr;
            if(key < curr.val) {
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        if(curr == null) {
            return root;
        }
        
            if(curr.left == null || curr.right == null) {
                TreeNode newCurr;
                if(curr.left == null) {
                    newCurr = curr.right;
                }
                else {
                    newCurr = curr.left;
                }
                if(prev == null) {
                    return newCurr;
                }
                if(curr == prev.left) {
                    prev.left = newCurr;
                }
                else{
                    prev.right = newCurr;
                }
            }
        else {
            TreeNode p = null;
            TreeNode temp = curr.right;
            while(temp.left != null) {
                p = temp;
                temp = temp.left;
            }
            if(p != null) {
                p.left = temp.right;
            }
            else {
                curr.right = temp.right;

            }
            curr.val = temp.val;
        }
        return root;
        
    }
}