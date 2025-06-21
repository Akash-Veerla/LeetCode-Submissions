class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            freq.put(ch, 1 + freq.getOrDefault(ch, 0));
        }
        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);
        int n = counts.size(), ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int range = counts.get(i) + k, total = counts.get(i);
            for (int j = i + 1; j < n; j++) {
                if (counts.get(j) > range) {
                    total += range;
                } else {
                    total += counts.get(j);
                }
            }
            int remain = word.length() - total;
            ans = Math.min(ans, remain);
        }
        return ans;
    }
}