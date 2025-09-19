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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recurse(nums, 0, nums.length, null);
    }

    private TreeNode recurse(int[] nums, int low, int high, TreeNode node) {
        int middle = low + (high - low) / 2;
        if (node == null) {
            node = new TreeNode(nums[middle]);
        } else {
            node.val = nums[middle];
        }
        if (high - low == 0) {
            return node;
        }
        if (low < middle) {
            node.left = recurse(nums, low, middle, new TreeNode());
        }
        if (middle + 1 < high) {
            node.right = recurse(nums, middle + 1, high, new TreeNode());
        }

        return node;
    }
}