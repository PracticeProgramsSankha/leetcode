package com.datastructure.recursion;

/**
 * @author sanray on 10/30/2021
 */
public class FibonacciDemoWithCaching {
    public static void main(String[] args) {
        printFibonacci(6);
        printFibonacci(10);
    }

    public static void printFibonacci(int maxTerm) {
        System.out.print("\nFibonacci of " + maxTerm + ": ");
        int[] cache = new int[maxTerm];
        for (int i = 0; i < maxTerm; i++) {
            initCache(cache);
            System.out.print(fibonacci(i, cache) + " ");
        }
    }

    private static void initCache(final int[] cache) {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
    }

    private static int fibonacci(final int maxTerm, int[] cache) {
        if (maxTerm == 0 || maxTerm == 1) {
            cache[maxTerm] = maxTerm;
            return cache[maxTerm];
        }

        if (cache[maxTerm] == -1) {
            cache[maxTerm] = fibonacci(maxTerm - 1, cache) + fibonacci(maxTerm - 2, cache);
        }
        return cache[maxTerm];
    }
}
