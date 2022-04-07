package com.leetcode.challenges;

import java.util.*;


public class MeetingRoom {

    public static void main(String[] args) {
        int[][] intervals1 = new int[][] {
                { 0, 30 },
                { 5, 10 },
                { 15, 20 }
        };
        if (minRooms(intervals1) == 2) {
            System.out.println("Test case 1 passed.");
        }
        int[][] intervals2 = new int[][] {
                { 7, 10 },
                { 2, 4 }
        };
        if (minRooms(intervals2) == 1) {
            System.out.println("Test case 2 passed.");
        }

        int[][] intervals3 = new int[][] {
                { 7, 10 },
                { 2, 4 },
                { 5, 11 },
        };
        if (minRooms(intervals3) == 2) {
            System.out.println("Test case 3 passed.");
        }
    }

    /*
       StartTime  = _ _ _ _ _
                  = 0, 5, 15
        EndArray  = 30, 10, 20
                    1,

    */
    private static int minRooms(int[][] intervals) {

        int totalIntervals = intervals.length;

        if (totalIntervals == 0) {
            return 0;
        }

        if (totalIntervals == 1) {
            return 1;
        }
        int[] startTime = new int[totalIntervals];
        int[] endTime = new int[totalIntervals];
        for (int interval = 0; interval < totalIntervals; interval++) {
            startTime[interval] = intervals[interval][0];
            endTime[interval] = intervals[interval][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int maxOccupancy = 0;
        int currentOccupancy = 0;
        int start = 0;
        int end = 0;
        while (start < totalIntervals) {
            if (startTime[start] < endTime[end]) {
                start++;
                currentOccupancy++;
            } else {
                end++;
                currentOccupancy--;
            }
            maxOccupancy = Math.max(maxOccupancy, currentOccupancy);

        }

        return currentOccupancy;
    }
}
