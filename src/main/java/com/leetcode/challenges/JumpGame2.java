package com.leetcode.challenges;

import java.util.Stack;


/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * @author sanray on 12/10/2021
 */
public class JumpGame2 {
    public static void main(String[] args) {

        test1();
        test2();
        test3();
    }

    private static void test1() {
        System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }));
    }

    private static void test3() {
        System.out.println(jump(new int[] { 2, 3, 0, 1, 4 }));
    }

    private static void test2() {
        System.out.println(
                jump(new int[] { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0,
                        3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5,
                        1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 }));
    }

    public static int jump(int[] nums) {

        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        backTrack(nums, 0, stack, res);
        return res[0];

    }

    public static void backTrack(int[] nums, int index, Stack<Integer> stack, int[] res) {
        if (index >= nums.length - 1) {
            res[0] = Math.min(res[0], stack.size() -1);
            return;
        }

        if (nums[index] == 0) {
            return;
        }

        if (stack.size() < res[0]) {
            for (int i = nums[index]; i >= 1; i--) {
                stack.push(index + i);
                backTrack(nums, index + i, stack, res);
                stack.pop();
            }
        }
    }
}
