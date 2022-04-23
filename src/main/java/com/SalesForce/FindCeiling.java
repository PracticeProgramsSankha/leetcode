package com.SalesForce;

import org.junit.Assert;


/**
 * @author sanray on 4/23/2022
 */
public class FindCeiling {
    public static void main(String[] args) {
        FindCeiling sol = new FindCeiling();

        Assert.assertEquals("TEST1", 8,
                sol.findCeiling(new int[] { 1, 2, 3, 5, 8, 9, 24 }, 7));
        Assert.assertEquals("TEST1", 3,
                sol.findCeiling(new int[] { 1, 2, 3, 5, 8, 9, 24 }, 3));
        Assert.assertEquals("TEST1", 1,
                sol.findCeiling(new int[] { 1, 2, 3, 5, 8, 9, 24 }, 0));
        Assert.assertEquals("TEST1", 5,
                sol.findCeiling(new int[] { 1, 2, 3, 5, 8, 9, 24 }, 4));
        Assert.assertEquals("TEST1", 25,
                sol.findCeiling(new int[] { 1, 2, 3, 5, 8, 9, 24 }, 25));
        System.out.println("ALL TEST PASSED!!");
    }

    int findCeiling(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        if(target > nums[right-1]) {
            return target;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];

    }

}
