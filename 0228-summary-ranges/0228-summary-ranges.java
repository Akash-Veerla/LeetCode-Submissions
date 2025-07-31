class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0, k = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] - nums[k] == 1) {
                j++;
                k++;
            } else {
                String a = (i == k) ? nums[i] + "" : nums[i] + "->" + nums[k];
                ans.add(a);
                i = j;
                k = j;
                j++;
            }
        }
        if (nums.length > 0) {
            String a = (i == k) ? nums[i] + "" : nums[i] + "->" + nums[k];
            ans.add(a);
        }
        return ans;
    }
}