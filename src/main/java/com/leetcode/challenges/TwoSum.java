package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author sanray on 10/20/2021
 */
public class TwoSum {

    public int[] twoSumUsingMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[] { map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return null;

    }

    public int[] twoSum(int[] nums, int target) {
        List<Integer> indices = new ArrayList<>();
        boolean bFound = false;
        for (int i = 0; i < nums.length - 1 && !bFound; i++) {
            for (int j = i+1; j < nums.length; j++) {

                int distance = target - (nums[i] + nums[j]);
                if (distance == 0) {
                    return new int[] { i, j };
                }
            }
        }

        return null;

    }

    public static void main(String[] args) {
        {
            int nums[] = { 2, 7, 11, 15 };
            TwoSum ch = new TwoSum();
            print(ch.twoSum(nums, 9));
            print(ch.twoSumUsingMap(nums, 9));
        }
        {
            int nums[] = { 3, 2, 4 };
            TwoSum ch = new TwoSum();
            print(ch.twoSum(nums, 6));
            print(ch.twoSumUsingMap(nums, 6));
        }

        {
            int nums[] = { -1, -2, -3, -4, -5 };
            TwoSum ch = new TwoSum();
            print(ch.twoSum(nums, -8));
            print(ch.twoSumUsingMap(nums, -8));
        }

    }

    public static void print(int[] result) {
        for(int i=0; i < result.length; i++) {
             System.out.print(result[i] + " ");
         };
        System.out.println("\n");
    }
}

