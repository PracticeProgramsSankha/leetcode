package com.leetcode.challenges;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author sanray on 11/12/2021
 */
public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 6, 5, 4, 8, 6, 8, 7, 8, 9, 4, 5 }));
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - buyPrice;
            if (diff > maxProfit) {
                maxProfit = prices[i] - buyPrice;
            } else if (diff < 0) {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
        }
}
