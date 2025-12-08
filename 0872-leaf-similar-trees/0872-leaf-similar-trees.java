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
    private void findLeaf(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        findLeaf(root.left, list);
        findLeaf(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        findLeaf(root1, list1);
        findLeaf(root2, list2);
        if (list1.equals(list2))
            return true;
        return false;
    }
}