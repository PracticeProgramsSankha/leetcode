package com.leetcode.challenges;

/**
 * @author sanray on 11/12/2021
 */
public class RemoveElements {
    public static void main(String[] args) {

        System.out.println(removeElement(new int[] { 0,1,2,2,3,0,4,2 }, 2));

        System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 3));
    }

    public static int removeElement(int[] nums, int val) {

        int index = 0;
        for(int i : nums) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;

    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
