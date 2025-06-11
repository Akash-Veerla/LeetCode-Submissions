class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int sum = nums[i] + nums[j];
                    if (sum == target) return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}