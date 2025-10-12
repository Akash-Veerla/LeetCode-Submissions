class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var result = new ArrayList<List<Integer>>();
        var pq = new PriorityQueue<P>((a, b) -> a.sum - b.sum);

        int n1 = nums1.length, n2 = nums2.length;
        for (int i = 0; i < Math.min(n1, k); i++) {
            pq.add(new P(i, 0, nums1[i] + nums2[0]));
        }

        while (k > 0 && !pq.isEmpty()) {
            P p = pq.poll();
            result.add(List.of(nums1[p.i], nums2[p.j]));
            if (p.j + 1 < n2) {
                pq.add(new P(p.i, p.j + 1, nums1[p.i] + nums2[p.j + 1]));
            }
            k--;
        }

        return result;
    }

    public class P {
        int i, j, sum;

        public P(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}