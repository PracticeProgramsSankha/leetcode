package com.datastructure;

/**
 * @author sanray on 10/26/2021
 */
public class Utility {
    public static void printArray(final String msg, final int[] arr) {
        System.out.print(msg + " ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();

    }
}
