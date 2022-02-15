package com.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * @author sanray on 11/8/2021
 */
public class KSumPairs {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[] { 1, 2, 3, 4 }, 5));
        System.out.println(maxOperations(new int[] { 2, 2, 2, 3, 1, 1, 4, 1 }, 4));

        System.out.println(maxOperations(new int[] { 2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2 }, 3));
        System.out.println(maxOperations(new int[] { 2, 2, 2, 3, 1, 1, 4, 1 }, 4));
    }

    public static int maxOperations(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (int i : map.keySet()) {
            if (map.containsKey(i) && map.containsKey(k - i)) {
                if (i != k - i) {
                    count += Math.min(map.get(i), map.get(k - i));
                    map.put(i, 0);
                    map.put(k - i, 0);
                } else {
                    count += Math.floor(map.get(i) / 2);
                    map.put(i, 0);
                }
            }
        }

        return count;

    }
}
