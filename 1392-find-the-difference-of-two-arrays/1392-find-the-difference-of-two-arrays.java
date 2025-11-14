class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) set2.add(num);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) l1.add(num);
        }
        ans.add(l1);
        for (int num : set2) {
            if (!set1.contains(num)) l2.add(num);
        }
        ans.add(l2);
        return ans;
    }
}