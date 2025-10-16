package ADA;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int buy = prices[0];
        int profit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    public int maxProfitAlt(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int buy = prices[0];
        int profit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }
}
