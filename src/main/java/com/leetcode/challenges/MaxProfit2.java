package com.leetcode.challenges;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://www.youtube.com/watch?v=3SJ3pUkPQMc
 * @author sanray on 4/20/2022
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        MaxProfit2 sol = new MaxProfit2();
        Assert.assertEquals("TEST1", 7, sol.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assert.assertEquals("TEST2", 4, sol.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println("All test passed");
    }

    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;

    }
}