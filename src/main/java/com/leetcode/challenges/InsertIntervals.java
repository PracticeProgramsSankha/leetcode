package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


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

        int indx = 0;
        // 1. Check if newInterval start is greater and exisitng intervals, add them
        while (indx < intervals.length && intervals[indx][1] < newInterval[0]) {
            result.add(intervals[indx++]);
        }
        // 2. At this point intervals will be overlapping, means existing interval start is less than newIntervalEnd
        while (indx < intervals.length && intervals[indx][0] <= newInterval[1]) {
            // Absorb new interval
            newInterval[0] = Math.min(newInterval[0], intervals[indx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[indx][1]);
            indx++;
        }
        // 3. Add the new interval
        result.add(newInterval);

        // 4. Add Remaining interval
        while (indx < intervals.length) {
            result.add(intervals[indx]);
            indx++;
        }

        return result.toArray(new int[result.size()][2]);

    }
}
