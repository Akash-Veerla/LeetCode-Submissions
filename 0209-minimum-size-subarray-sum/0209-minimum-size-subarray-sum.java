class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, sum = 0, len = 0, ans = Integer.MAX_VALUE;
        for (int i : nums) {
            sum += i;
            len++;
            while (sum >= target) {
                ans = Math.min(len, ans);
                sum -= nums[start];
                start++; len--;
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}