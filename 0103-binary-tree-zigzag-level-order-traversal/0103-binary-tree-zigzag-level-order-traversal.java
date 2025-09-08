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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null)
            return sol;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isForward = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            while (0 < levelSize--) {
                TreeNode node = queue.poll();
                if (isForward)
                    level.addLast(node.val);
                else
                    level.addFirst(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            sol.add(level);
            isForward = !isForward;
        }
        return sol;
    }
}