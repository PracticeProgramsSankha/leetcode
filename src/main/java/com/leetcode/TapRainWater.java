package com.leetcode;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 04/10/2022
 */

public class TapRainWater {
    public static void main(String[] args) {
        TapRainWater sol = new TapRainWater();
        Assert.assertEquals("Test1", 6, sol.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println("All Test Passed..");
    }

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int maxLeft = height[left];
        int maxRight = height[right];
        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                water += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                water += maxRight - height[right];
            }
        }
        return water;
    }
}
