class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;
        for (int i : prices) {
            if (i < buy) {
                buy = i;
            } else if ((i - buy) > profit) {
                profit = i - buy;
            }
        }
        return profit;
    }
}