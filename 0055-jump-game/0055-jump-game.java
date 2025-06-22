class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int index = n - 1;
        int pointer = index - 1;
        if (n == 1) {
            return true;
        }
        while (0 <= pointer) {
            if (nums[pointer] + pointer >= index) {
                index = pointer;
            }
            pointer--;
        }
        if (0 >= index) {
            return true;
        }
        return false;
    }
}