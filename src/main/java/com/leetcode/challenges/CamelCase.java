package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sanray on 12/6/2021
 */
public class CamelCase {
    public static void main(String[] args) {

        test1();
        test2();
        test3();

    }

    private static void test3() {
        System.out.println("test3 expected: [false,true,false,false,false]");
        System.out
                .println(camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
                        "FoBaT"));
    }

    private static void test2() {
        System.out.println("test2 expected: [true,false,true,false,false]");
        System.out
                .println(camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
                        "FoBa"));
    }

    private static void test1() {
        System.out.println("test1 expected:  [true,false,true,true,false]]");
        System.out.println(camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer",
                        "ForceFeedBack" },
                "FB"));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> result = new ArrayList<>();
        for (String q : queries) {
            //System.out.println(q);
            result.add(backTrack(q, 0, pattern, 0));
        }

        return result;

    }

    public static boolean backTrack(String q, int qIndex, String p, int pIndex) {
        if (qIndex == q.length() && pIndex == p.length()) {
            return true;
        }

        if (qIndex < q.length()) {
            final char cQuery = q.charAt(qIndex);
            if (pIndex < p.length() && q.charAt(qIndex) == p.charAt(pIndex)) {
                return backTrack(q, qIndex + 1, p, pIndex + 1);
            } else if (cQuery >= 'a' && cQuery <= 'z') {
                return backTrack(q, qIndex + 1, p.substring(0, pIndex) + cQuery + p.substring(pIndex), pIndex + 1);
            }
        }

        return false;
    }
}
