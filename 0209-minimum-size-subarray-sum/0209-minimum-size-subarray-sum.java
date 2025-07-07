class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}

/*
int left = 0, currentSum = 0, minLength = Integer.MAX_VALUE;
for (int right = 0; right < nums.length; right++) {
    currentSum += nums[right];
    while (currentSum >= target) {
        minLength = Math.min(minLength, right - left + 1);
        currentSum -= nums[left++];
    }
}
return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
*/