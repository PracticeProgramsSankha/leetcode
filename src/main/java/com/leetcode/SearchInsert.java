package com.leetcode;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * @author sanray on 4/23/2022
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert sol = new SearchInsert();

        Assert.assertEquals("TEST1", 1, sol.searchInsert(new int[] { 1, 3 }, 2));
        Assert.assertEquals("TEST1", 2, sol.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        Assert.assertEquals("TEST1", 0, sol.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
        Assert.assertEquals("TEST1", 3, sol.searchInsert(new int[] { 1, 3, 5, 6 }, 6));
        Assert.assertEquals("TEST1", 4, sol.searchInsert(new int[] { 1, 3, 5, 6 }, 7));

        System.out.println("all tests passed");
    }

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
