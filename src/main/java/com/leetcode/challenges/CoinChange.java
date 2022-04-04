package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[] { 1, 2, 5 }, 6));
        System.out.println(sol.coinChange(new int[] { 186, 419, 83, 408 }, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int[] knapsack = new int[amount + 1];
        Arrays.fill(knapsack, amount + 1);
        knapsack[0] = 0;
        for (int amt = 1; amt < knapsack.length; amt++) {
            for (int c : coins) {
                if (amt - c >= 0) {
                    knapsack[amt] = Math.min(knapsack[amt], 1 + knapsack[amt - c]);
                }
            }
        }
        return knapsack[amount] == amount + 1 ? -1 : knapsack[amount];

    }

    public int coinChange1(int[] coins, int amount) {

        int numCoins = coins.length;
        if (numCoins == 0 || amount == 0) {
            return -1;
        }
        int[][] knapsack = new int[numCoins + 1][amount + 1];
        for (int[] row : knapsack) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int c = 0; c <= numCoins; c++) {
            for (int amt = 0; amt <= amount; amt++) {
                if (amt == 0) { // Zero Amount
                    knapsack[c][amt] = 0;
                } else if (c == 0) {  // No Coins present
                    knapsack[c][amt] = Integer.MAX_VALUE;
                } else if (coins[c - 1] > amt) {
                    knapsack[c][amt] = knapsack[c - 1][amt];
                } else {
                    knapsack[c][amt] = Math.min(1 + knapsack[c][amt - coins[c - 1]], knapsack[c - 1][amt]);
                }
            }
        }

        print(knapsack);

        return knapsack[numCoins][amount] == Integer.MAX_VALUE ? -1 : knapsack[numCoins][amount];

    }

    public void print(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
