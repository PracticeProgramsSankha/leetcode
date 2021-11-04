package com.leetcode.challenges;

/**
 * @author sanray on 10/31/2021
 */
public class ReverseNumber {
    public static void main(String[] args) {
/*        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));*/
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x == 0 || x >= Integer.MAX_VALUE) {
            return 0;
        }
        int reverse = 0;
        int temp = Math.abs(x);
        while (temp > 0) {

            if (reverse > (Integer.MAX_VALUE - temp % 10) / 10) {
                return 0;
            }
            reverse = reverse * 10 + (temp % 10);
            temp = temp / 10;
        }
        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }

        return x > 0 ? reverse : -reverse;

    }
}
