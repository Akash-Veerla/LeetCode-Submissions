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
    private int min = Integer.MAX_VALUE;
    private int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }

    private void find(TreeNode root) {
        if (root == null)
            return;

        find(root.left);

        if (prev != -1) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        find(root.right);
    }
}