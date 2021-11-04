package com.leetcode.challenges;

/**
 * @author sanray on 10/31/2021
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));

        System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));

    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int lastUpdatedIndex = 0;
        for (int i = lastUpdatedIndex; i < nums.length - 1;) {
            for (int currentIndex = i + 1; currentIndex < nums.length; ) {
                if (nums[lastUpdatedIndex] != nums[currentIndex]) {
                    lastUpdatedIndex++;
                    nums[lastUpdatedIndex] = nums[currentIndex];
                }
                currentIndex++;
                i++;
            }
        }

        return lastUpdatedIndex + 1;
    }
}
