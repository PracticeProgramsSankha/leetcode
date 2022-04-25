package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/combination-sum/
 *
 * @author sanray on 12/9/2021
 */
public class CombinationSum {
    public static void main(String[] args) {

        test1();
        test2();

        System.out.println("All test passed!!");

    }

    private static void test1() {

        Assert.assertEquals("TEST1",
                Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7)),
                combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    }

    private static void test2() {

        Assert.assertEquals("TEST1",
                Arrays.asList(
                        Arrays.asList(2, 2, 2, 2),
                        Arrays.asList(2, 3, 3),
                        Arrays.asList(3, 5)),
                combinationSum(new int[] { 2, 3, 5 }, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Stack<Integer> list = new Stack<>();
        List<List<Integer>> results = new ArrayList<>();
        backTrack(candidates, target, 0, list, results);
        return results;

    }

    public static void backTrack(int[] candidates, int target, int index, Stack<Integer> list,
            List<List<Integer>> results) {
        int n = candidates.length;
        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }

        if (index == n) {
            if (target == 0) {
                results.add(new ArrayList<>(list));
            }
            return;
        }

        if (candidates[index] <= target) {
            // Repeating itself
            list.push(candidates[index]);
            backTrack(candidates, target - candidates[index], index, list, results);
            list.pop();
        }

        backTrack(candidates, target, index + 1, list, results);

    }
}
