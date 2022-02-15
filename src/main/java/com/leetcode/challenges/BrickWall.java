package com.leetcode.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/brick-wall/
 * @author sanray on 12/7/2021
 */
public class BrickWall {
    public static void main(String[] args) {

        //test1();
        test2();

    }

    private static void test2() {
        System.out.println(leastBricks(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(2),
                Arrays.asList(2))));
    }

    private static void test1() {
        System.out.println(leastBricks(Arrays.asList(
                Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 2), Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 1, 1))));
    }

    public static int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> gapsMap = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;

        for(List<Integer> rows : wall) {
            int gap = 0;
            for(int row = 0; row < rows.size() -1 ; row++) {
                gap += rows.get(row);
                int count = gapsMap.getOrDefault(gap, 0) + 1;
                gapsMap.put(gap, count);
                maxCount = Math.max(maxCount, count);
            }
        }

        // Min Cut = rows - maxGapCount
        return wall.size() - Math.max(maxCount, 0);

    }
}
