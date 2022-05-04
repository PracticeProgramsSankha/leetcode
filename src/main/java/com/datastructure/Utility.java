package com.datastructure;

import java.util.List;


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

    public static void print2DArray(final String msg, final int[][] arr) {
        System.out.print(msg + " -> \n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.print("]\n");
        }
        System.out.println();
    }

    public static void print2DArrayList(final String msg, final List<int[]> arr) {
        System.out.print(msg + " -> ");
        for(int[] num : arr) {
            System.out.print(String.format("[%d,%d]", num[0], + num[1]));
        }
    }


}
