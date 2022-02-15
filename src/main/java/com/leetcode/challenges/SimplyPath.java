package com.leetcode.challenges;

import java.util.Stack;


/**
 * @author sanray on 12/18/2021
 */
public class SimplyPath {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        //System.out.println(simplifyPath("/home/"));
        //System.out.println(simplifyPath("/../"));
        //System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }

        Stack<String> stack = new Stack<>();

        String[] tokens = path.split("/");
        for (String s : tokens) {
            switch (s) {
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case ".":
                case "":
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        if (!stack.isEmpty()) {
            sb.append(String.join("/", stack));
        }

        return sb.toString();

    }
}
