package com.datastructure.sorts;

import static jdk.nashorn.internal.objects.Global.print;


/**
 * @author sanray on 10/26/2021
 */
public class SelectionSortDemo {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    // Update minIndex
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            print("iter" + i, arr);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 30, 12, 14, 15, 7, 9, 10, 1 };
        print("Before: ", arr);
        selectionSort(arr);
        print("After:", arr);

    }

}
