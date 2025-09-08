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
    int val = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root.right == null && root.left == null)
            return 1;
        INORDER(root, k);
        return val;
    }

    void INORDER(TreeNode root, int k) {
        if (root == null)
            return;
        INORDER(root.left, k);
        count++;
        if (count == k)
            val = root.val;
        INORDER(root.right, k);
    }
}