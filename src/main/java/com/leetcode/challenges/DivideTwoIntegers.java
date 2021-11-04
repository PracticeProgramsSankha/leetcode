package com.leetcode.challenges;

/**
 * @author sanray on 10/31/2021
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        //  System.out.println(divide(-2147483648, -1));

        // System.out.println(divide(12323232, 123));
        System.out.println(divide(-1, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend >= 0) == (divisor >= 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            result += 1 << count;
            dividend -= divisor << count;
        }

        return sign ? result : -result;

    }
}
