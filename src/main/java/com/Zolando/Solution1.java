package com.Zolando;

import java.util.Arrays;


/**
 * @author sanray on 3/18/2022
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println(sol.solution(new int[] { 1, 3, 6, 4, 1, 2 }));
        System.out.println(sol.solution(new int[] { 1, 2, 3 }));
        System.out.println(sol.solution(new int[] { -1, -3 }));

    }

    public int solution(int[] nums) {
        // write your code in Java SE 8

        int n = nums.length;

        // To mark the occurrence of elements
        boolean[] present = new boolean[n + 1];

        // Mark the occurrences
        for (int i = 0; i < n; i++) {

            // Only mark the required elements
            // All non-positive elements and
            // the elements greater n + 1 will never
            // be the answer
            // For example, the array will be {1, 2, 3}
            // in the worst case and the result
            // will be 4 which is n + 1
            if (nums[i] > 0 && nums[i] <= n)
                present[nums[i]] = true;
        }

        // Find the first element which didn't
        // appear in the original array
        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;

        // If the original array was of the
        // type {1, 2, 3} in its sorted form
        return n + 1;
    }
}
