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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        return dfs(root, 0, targetSum, prefixMap);
    }

    int dfs(TreeNode node, long sum, int target, Map<Long, Integer> prefixMap) {
        if (node == null)
            return 0;
        sum += node.val;

        int count = prefixMap.getOrDefault(sum - target, 0);

        prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);

        count += dfs(node.left, sum, target, prefixMap);
        count += dfs(node.right, sum, target, prefixMap);

        prefixMap.put(sum, prefixMap.get(sum) - 1);

        return count;
    }
}