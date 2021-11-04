package com.leetcode.challenges;

import java.util.stream.Stream;


/**
 * @author sanray on 10/31/2021
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        System.out.println(longestSubsequence(new int[] { 0, 1, 3, 2 }));
    }

    public static int longestSubsequence(int[] nums) {
        int[] LIS = new int[nums.length];
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }
        return findMax(LIS);
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

}
