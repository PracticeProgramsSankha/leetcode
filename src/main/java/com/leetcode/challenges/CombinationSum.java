package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author sanray on 12/9/2021
 */
public class CombinationSum {
    public static void main(String[] args) {

        test1();

    }

    private static void test1() {
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
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
            list.push(candidates[index]);
            backTrack(candidates, target - candidates[index], index, list, results);
            list.pop();
        }

        backTrack(candidates, target, index + 1, list, results);

    }
}
