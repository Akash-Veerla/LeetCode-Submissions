class Solution {
    public int bs(int spell, int[] potions, long success) {
        int l = 0;
        int h = potions.length - 1;
        long product;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            product = (long) potions[mid] * spell;
            if (product < success)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return potions.length - l;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            ans[i] = bs(spells[i], potions, success);
        }
        return ans;
    }
}