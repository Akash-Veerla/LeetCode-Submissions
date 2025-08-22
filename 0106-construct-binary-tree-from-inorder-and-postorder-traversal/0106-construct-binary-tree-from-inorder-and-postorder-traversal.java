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
    private Map<Integer, Integer> inorderMap;
    private int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postorderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = postorder[postorderIndex--];
        TreeNode root = new TreeNode(val);
        int mid = inorderMap.get(val);
        root.right = helper(postorder, mid + 1, right);
        root.left = helper(postorder, left, mid - 1);
        return root;
    }
}