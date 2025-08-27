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
    private int helpSum(TreeNode root, int total) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return total * 10 + root.val;
        }
        int left = helpSum(root.left, total * 10 + root.val);
        int right = helpSum(root.right, total * 10 + root.val);
        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return helpSum(root, 0);
    }
}