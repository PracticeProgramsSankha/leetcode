package com.leetcode.challenges;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * @author sanray on 3/21/2022
 */
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        LongestConsecutiveSeq sol = new LongestConsecutiveSeq();
        System.out.println(sol.longestConsecutive(new int[] { 1,2,0,1 }));
        System.out.println(sol.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(sol.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        System.out.println(sol.longestConsecutive(new int[] { -2, -1, -3, -4, 0 }));
        System.out.println(sol.longestConsecutive(new int[] {  }));
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length <=1 ) {
            return nums.length;
        }
        Arrays.sort(nums);
        int maxSeq = Integer.MIN_VALUE;
        int curr_sq = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                curr_sq++;
            } else {
                maxSeq = Math.max(curr_sq, maxSeq);
                curr_sq = 1;
            }
        }

        return Math.max(curr_sq, maxSeq);

    }
}
