package com.datastructure.recursion;

/**
 * @author sanray on 10/28/2021
 */
public class EuclidDemo {
    public static void main(String[] args) {
        findGcd(43, 10);
        findGcd(6, 4);
    }

    private static void findGcd(final int a, final int b) {
        System.out.println(String.format("GCD of %d and %d is %d", a, b, gcd(a, b)));
    }

    private static int gcd(final int a, final int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
