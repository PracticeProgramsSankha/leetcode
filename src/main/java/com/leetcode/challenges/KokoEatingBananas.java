package com.leetcode.challenges;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * <p>
 * https://www.youtube.com/watch?v=U2SozAs9RzA
 *
 * @author sanray on 4/26/2022
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas sol = new KokoEatingBananas();
        Assert.assertEquals("TEST4", 2, sol.minEatingSpeed(new int[] { 312884470 }, 312884469));
        Assert.assertEquals("TEST3", 1, sol.minEatingSpeed(new int[] { 312884470 }, 968709470));
        Assert.assertEquals("TEST1", 4, sol.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
        Assert.assertEquals("TEST2", 30, sol.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));

        System.out.println("All test passed!!");

    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int minRate = max;
        while (left <= right) {
            int currentBananaEatingRate = (left + right) / 2;
            int totalHours = 0;
            // Compute how much time would take to eat all piles with current rate
            for (int i = 0; i < piles.length; i++) {
                totalHours += (piles[i] / currentBananaEatingRate) +
                        (piles[i] % currentBananaEatingRate != 0 ? 1 : 0); // it will return the ceiling value
            }

            if (totalHours <= h) {
                minRate = Math.min(minRate, currentBananaEatingRate);
                right = currentBananaEatingRate - 1;
            } else {
                left = currentBananaEatingRate + 1;
            }
        }

        return minRate;

    }
}
