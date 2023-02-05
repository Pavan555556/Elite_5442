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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ordr(root, list);
        Collections.sort(list);
        int min = 10000000;
        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i - 1) - list.get(i));
            if (min > diff) min = diff;
        }
        return min;
    }

    private void ordr(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        ordr(node.left, list);
        ordr(node.right, list);
    }
}