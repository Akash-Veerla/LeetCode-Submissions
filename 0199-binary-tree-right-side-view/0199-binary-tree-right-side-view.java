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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        if (root == null) {
            return res;
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = que.poll();
                if (i == size - 1) {
                    res.add(current.val);
                }
                if (current.left != null) {
                    que.offer(current.left);
                }
                if (current.right != null) {
                    que.offer(current.right);
                }
            }
        }
        return res;
    }
}