class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int j;
        for (int x : set) {
            if (set.contains(x - 1)) {
                continue;
            }
            j = 0;
            while (set.contains(x + j)) {
                j++;
            }
            ans = Math.max(ans, j);
        }
        return ans;
    }
}