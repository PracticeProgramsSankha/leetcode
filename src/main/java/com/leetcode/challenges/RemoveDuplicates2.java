package com.leetcode.challenges;

/**
 * @author sanray on 10/31/2021
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));

        System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));

    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length  < 3) {
            return nums.length;
        }

        int in = 2;
        for (int i = in; i < nums.length; i++) {
            if(nums[i] != nums[in-2]) {
                nums[in++] = nums[i];
            }
        }

        return in;
    }
}
