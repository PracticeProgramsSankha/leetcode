package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * @author sanray on 12/16/2021
 */
public class ContainsDuplicate2 {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    private static void test1() {
        System.out.println(containsNearbyAlmostDuplicate(new int[] { 8, 7, 15, 1, 6, 1, 9, 15 }, 1, 3));
    }

    private static void test2() {
        System.out.println(containsNearbyAlmostDuplicate(new int[] { -2147483648, 2147483647 }, 1, 1));
    }

    /**
     * [2147483646,2147483647]
     * 3
     * 3
     */
    private static void test3() {
        System.out.println(containsNearbyAlmostDuplicate(new int[] { 2147483646, 2147483647 }, 3, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int finalI = i;
            if (map.keySet().stream()
                    .filter(j -> !(nums[finalI] < 0 && nums[finalI] - j > 0 || (nums[finalI] > 0
                            && nums[finalI] + j < 0)))
                    .filter(j -> Math.abs(nums[finalI] - j) <= t)
                    .flatMap(j -> map.get(j).stream())
                    .anyMatch(j -> Math.abs(j - finalI) <= k)) {
                return true;
            }

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            List<Integer> list = map.get(nums[i]);
            list.add(i);
        }

        return false;

    }
}
