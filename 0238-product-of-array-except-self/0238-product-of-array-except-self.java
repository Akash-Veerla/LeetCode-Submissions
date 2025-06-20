class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1, suf = 1;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = pre;
            pre *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suf;
            suf *= nums[i];
        }
        return answer;
    }
}