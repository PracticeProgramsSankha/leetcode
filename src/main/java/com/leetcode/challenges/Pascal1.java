package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * https://leetcode.com/problems/pascals-triangle/submissions/
 * @author sanray on 11/13/2021
 */
public class Pascal1 {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(10));
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(result.get(i - 1).get(0));
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }

        return result;

    }
}
