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
    public List<Double> ans = new ArrayList<>();
    public List<Integer> num = new ArrayList<>();

    public void calculate(TreeNode root, int level) {
        if (root == null) return;
        
        if (ans.size() <= level) {
            ans.add(0.0);
            num.add(0);
        }
        
        ans.set(level, ans.get(level) + root.val);
        num.set(level, num.get(level) + 1);
        
        calculate(root.left, level + 1);
        calculate(root.right, level + 1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        calculate(root, 0);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / num.get(i));
        }
        return ans;
    }
}