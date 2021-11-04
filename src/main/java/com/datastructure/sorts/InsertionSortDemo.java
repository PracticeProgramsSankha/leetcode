package com.datastructure.sorts;

import com.datastructure.Utility;


/**
 * @author sanray on 10/26/2021
 */
public class InsertionSortDemo {
    // Take an element and check until the element is greater than prev elements,
    // shift all elements to right and insert the element.
    public static void insertionSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
            Utility.printArray("iter" + i, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 30, 12, 14, 15, 7, 9, 10, 1 };
        Utility.printArray("Before: ", arr);
        insertionSort(arr);
        Utility.printArray("After:", arr);
    }
}
