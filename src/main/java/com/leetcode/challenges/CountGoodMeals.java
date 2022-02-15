package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/count-good-meals/
 *
 * @author sanray on 11/7/2021
 */
public class CountGoodMeals {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[] { 2 }));

        System.out.println(countPairs(new int[] { 1, 3, 5, 7, 9 }));
        System.out.println(countPairs(new int[] { 1, 1, 1, 3, 3, 3, 7 }));

        System.out.println(countPairs(
                new int[] { 2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246,
                        1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468 }));

    }

    public static int countPairs(int[] deliciousness) {

        if (deliciousness.length == 1) {
            return isPowerOfTwo(deliciousness[0]) ? 1 : 0;
        }


        int num = 1_000_000_007;
        int count = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int number = deliciousness[i] + deliciousness[j];
                boolean isPowerOf2 = isPowerOfTwo(number);
                if (isPowerOf2) {
                    count++;
                }
            }
        }

        return count;

    }

    public static int countPairs1(int[] deliciousness) {

        if (deliciousness.length == 1) {
            return isPowerOfTwo(deliciousness[0]) ? 1 : 0;
        }

        int count = 0;
        List<Tuple> list = new ArrayList<>();
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {

                int number = deliciousness[i] + deliciousness[j];
                boolean isPowerOf2 = isPowerOfTwo(number);
                if (isPowerOf2) {
                    list.add(new Tuple(deliciousness[i], deliciousness[j]));
                    count++;
                }

            }
        }

        System.out.println(list);

        return count;

    }

    static class Tuple {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override public String toString() {
            return String.format("%d,%d", a, b);
        }
    }

    public static boolean isPowerOfTwo(int number) {
        return (number & (number - 1)) == 0 && number != 0;
    }
}
