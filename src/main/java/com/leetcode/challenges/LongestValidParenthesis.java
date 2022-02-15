package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * @author sanray on 11/16/2021
 */
public class LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));

    }

    public static int longestValidParentheses(String s) {

        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == ')') {
                count++;
            }
        }

        int maxSize = 0;
        for (int c = count; c >= 1; c--) {
            Stack<String> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            generateParenthesis(0, 0, c, stack, list, s);
            maxSize = Math.max(maxSize, list.stream().max(Integer::compare).orElse(0));
            list.clear();
            stack.clear();
        }

        return maxSize;

    }

    private static void generateParenthesis(final int openN,
            final int closeN, int n, final Stack<String> stack, List<Integer> list, String originalString) {
        if (openN == n && closeN == n) {
            String paran = stack.stream().collect(Collectors.joining());
            if (originalString.indexOf(paran) != -1) {
                list.add(paran.length());
            }
            return;
        }

        if (openN < n) {
            stack.push("(");
            generateParenthesis(openN + 1, closeN, n, stack, list, originalString);
            stack.pop();
        }

        if (closeN < openN) {
            stack.push(")");
            generateParenthesis(openN, closeN + 1, n, stack, list, originalString);
            stack.pop();
        }
    }

}
