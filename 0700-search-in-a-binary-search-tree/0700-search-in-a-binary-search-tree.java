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
    TreeNode node = null;
    public TreeNode searchBST(TreeNode root, int val) {
        find(root, val);
        return node;
    }
    public void find(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            node = root;
            return;
        } else if (root.val > val) {
            find(root.left, val);
        } else {
            find(root.right, val);
        }
    }
}