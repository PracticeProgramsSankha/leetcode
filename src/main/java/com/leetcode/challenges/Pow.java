package com.leetcode.challenges;

/**
 * https://leetcode.com/problems/powx-n/submissions/
 *
 * @author sanray on 10/31/2021
 */
public class Pow {
    public static void main(String[] args) {
        //System.out.println(myPow(1.000000, 2147483647));
        //System.out.println(myPow(2.000000, -2147483648));
        //System.out.println(myPow( 0.44894,                 -5));
        //System.out.println(myPow( 0.999999999, -2147483648));
        Pow sol = new Pow();
        System.out.println(sol.myPow(2.00000, 5));
        System.out.println(sol.myPow(2.00000, -2147483648));
    }

    public double pow_util(double x, long n) {
        if (n == 0) {
            return 1.0f;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return pow_util(1 / x, -n);
        }

        double result = pow_util(x * x, n / 2);
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }

    public double myPow(double x, int n) {

        return pow_util(x, n);

    }

    public static double myPow1(double x, int n) {

        if (n == 0) {
            return 1.0f;
        }

        if (n == 1) {
            return x;
        }

        if (x < -100.0f || x >= 100.0f) {
            return 0.0f;
        }

        if (n <= Integer.MIN_VALUE) {
            if (1.0f == Math.abs(x)) {
                return 1.0f;
            }
          /*  else
                return 0.0f;*/
        }

        if (n >= Integer.MAX_VALUE) {
            if (1.0f == Math.abs(x)) {
                return 1.0f;
            } else {
                return 0.0f;
            }

        }

        if (x == -1.0f || x == 0.0f || x == 1.0f) {
            if (n == 0) {
                return 1.0f;
            } else {
                return x;
            }
        }

        double result = 1.0f;
        boolean isPositive = n > 0;
        int power = Math.abs(n);
        for (int i = 0; i < power; i++) {
            if (isPositive) {
                result = result * x;
            } else {
                result = result / x;
            }
        }

        return result;

    }
}
