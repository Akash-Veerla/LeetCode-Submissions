class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> rez = new ArrayList<Boolean>(candies.length);
        int max = 0;
        for (int num : candies) {
            if (num > max) {
                max = num;
            }
        }
        for (int num : candies) {
            if (num + extraCandies >= max) {
                rez.add(true);
            } else {
                rez.add(false);
            }
        }
        return rez;
    }
}