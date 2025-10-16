package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
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
}
