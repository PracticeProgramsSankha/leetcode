package com.leetcode.challenges;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;


/**
 * @author sanray on 10/31/2021
 */
public class GenerateParenthesis {

    public static void printParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        HashSet<String> res = new HashSet<>();
        generateParenthesis(0, 0, n, stack, res);
        System.out.println(String.format("Parenthesis with %d: [%s]", n, StringUtils.join(res, ",")));
    }

    public static void generateParenthesis(int open, int close, int n, Stack<String> stack, HashSet res) {
        if (open == n && close == n) {
            res.add(stack.stream().collect(Collectors.joining()));
            return;
        }

        if (open < n) {
            stack.push("(");
            generateParenthesis(open + 1, close, n, stack, res);
            stack.pop();
        }

        if (close < open) {
            stack.add(")");
            generateParenthesis(open, close + 1, n, stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        printParenthesis(1);
        printParenthesis(2);
        printParenthesis(3);
        printParenthesis(4);
    }

}
