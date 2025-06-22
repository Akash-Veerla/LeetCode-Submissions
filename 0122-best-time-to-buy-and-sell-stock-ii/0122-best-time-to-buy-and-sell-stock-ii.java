class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, lastBuy = prices[0];
        for (int i : prices) {
            if (i < lastBuy) {
                lastBuy = i;
            }
            if (i - lastBuy > 0) {
                profit += (i - lastBuy);
                lastBuy = i;
            }
        }
        return profit;
    }
}