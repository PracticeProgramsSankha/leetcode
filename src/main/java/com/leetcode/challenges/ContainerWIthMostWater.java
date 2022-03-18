package com.leetcode.challenges;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author sanray on 3/18/2022
 */
public class ContainerWIthMostWater {
    public static void main(String[] args) {
        ContainerWIthMostWater sol = new ContainerWIthMostWater();
        System.out.println(sol.findMaxWater(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(sol.findMaxWater(new int[] { 1, 1 }));
    }

    private int findMaxWater(final int[] nums) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int currArea = 0;
        int maxWater = 0;
        while (leftIndex < rightIndex) {
            currArea = Math.min(nums[leftIndex], nums[rightIndex]) * (rightIndex - leftIndex);
            if (currArea > maxWater) {
                maxWater = currArea;
            }
            if (nums[leftIndex] < nums[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxWater;

    }
}
