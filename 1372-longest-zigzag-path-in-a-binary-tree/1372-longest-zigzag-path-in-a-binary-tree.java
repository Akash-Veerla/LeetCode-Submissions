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
    int solve(TreeNode root, int step, boolean isRight) {
        if (root == null)
            return step - 1;
        int l = solve(root.left, isRight ? step + 1 : 1, false);
        int r = solve(root.right, !isRight ? step + 1 : 1, true);
        return Math.max(l, r);
    }

    public int longestZigZag(TreeNode root) {
        return solve(root, 0, false);
    }
}