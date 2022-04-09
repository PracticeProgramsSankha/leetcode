package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertIntervals {

    public static void main(String[] args) {
        InsertIntervals sol = new InsertIntervals();
        print(sol.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
                new int[] { 4, 8 }));
    }

    private static void print(final int[][] interval) {
        System.out.println("==============");
        for (int i = 0; i < interval.length; i++) {
            for (int j = 0; j < interval[0].length; j++) {
                System.out.print(interval[i][j] + " ");
            }
            System.out.print(", ");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int index = 0;
        // 1. Check if newInterval start is greater and exisitng intervals, add them
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }
        // 2. At this point intervals will be overlapping, means existing interval start is less than newIntervalEnd
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            // Absorb new interval
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        // 3. Add the new interval
        result.add(newInterval);

        // 4. Add Remaining interval
        while (index < intervals.length) {
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][2]);

    }
}
