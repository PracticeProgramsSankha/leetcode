package com.FB40;

import java.util.ArrayList;
import java.util.List;
import com.datastructure.Utility;


/**
 * @author sanray on 4/25/2022
 */
public class P02_MergeIntervals {
    public static void main(String[] args) {

        test1("TEST1");
        test2("TEST2");

    }

    private static void test1(final String test1) {
        P02_MergeIntervals sol = new P02_MergeIntervals();

        int[][] nums = new int[][] {
                { 1, 5 },
                { 3, 7 },
                { 4, 6 },
                { 6, 8 }
        };
        Utility.print2DArray("\nBefore", nums);
        Utility.print2DArrayList("After", sol.mergeIntervals(nums));
    }

    private static void test2(final String test1) {
        P02_MergeIntervals sol = new P02_MergeIntervals();

        int[][] nums = new int[][] {
                { 10, 12 },
                { 12, 15 }
        };
        Utility.print2DArray("\nBefore", nums);
        Utility.print2DArrayList("After", sol.mergeIntervals(nums));
    }

    public List<int[]> mergeIntervals(int[][] nums) {
        List<int[]> result = new ArrayList<>();
        result.add(new int[] { nums[0][0], nums[0][1] });

        for (int i = 1; i < nums.length; i++) {
            int[] v1 = nums[i];
            int[] v2 = result.get(result.size() - 1);
            // next position's start is less than existing then merge
            if (v1[1] >= v2[0]) {
                result.get(result.size() - 1)[1] = Math.max(v1[1], v2[1]);
            } else {
                // Add new
                result.add(nums[i]);
            }
        }

        return result;

    }
}
