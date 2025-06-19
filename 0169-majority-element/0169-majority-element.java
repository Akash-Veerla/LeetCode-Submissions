class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, majority = 0;
        for (int i : nums) {
            if (majority == 0) {
                result = i;
            }
            majority += (i == result) ? 1 : -1;
        }
        return result;
    }
}