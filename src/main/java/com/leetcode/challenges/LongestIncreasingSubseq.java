package com.leetcode.challenges;

import java.util.Arrays;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * https://www.youtube.com/watch?v=cjWnW0hdF1Y
 *
 * @author sanray on 4/19/2022
 */
public class LongestIncreasingSubseq {
    public static void main(String[] args) {
        test1();
        System.out.println("all test passed");

    }

    private static void test1() {
        LongestIncreasingSubseq sol = new LongestIncreasingSubseq();
        Assert.assertEquals("TEST1", 4, sol.lengthOfLIS(new int[] { 0, 3, 1, 6, 2, 2, 7 }));

    }

    public int lengthOfLIS(int[] nums) {

        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        int maxLength = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                    maxLength = Math.max(LIS[i], maxLength);
                }
            }
        }

        return maxLength;

    }
}
