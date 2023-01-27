/*
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root==null){
            return list;
        }
        int odd = 0;
        que.add(root);
        while (!que.isEmpty()){
            List<Integer> subList = new LinkedList<>();
            int size = que.size();
                for (int i = 0; i < size; i++) {
                    if (que.peek().left != null){
                        que.add(que.peek().left);
                    }
                    if (que.peek().right != null){
                        que.offer(que.peek().right);
                    }
                    subList.add(que.poll().val);
                }
            if (odd % 2 == 1){
                Collections.reverse(subList);
            }
            list.add(subList);
            odd++;
        }
        return list;
    }
}