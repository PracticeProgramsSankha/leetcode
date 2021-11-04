package com.datastructure.recursion;

/**
 * @author sanray on 10/30/2021
 */
public class FibonacciDemo {
    public static void main(String[] args) {
        printFibonacci(6);
        printFibonacci(10);
    }

    public static void printFibonacci(int maxTerm) {
        System.out.print("\nFibonacci of " + maxTerm + ": ");
        for (int i = 0; i < maxTerm; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    private static int fibonacci(final int maxTerm) {
        if (maxTerm == 0 || maxTerm == 1) {
            return maxTerm;
        }

        return fibonacci(maxTerm - 1) + fibonacci(maxTerm - 2);
    }
}
