package com.datastructure.sorts;

import com.datastructure.Utility;


/**
 * @author sanray on 10/26/2021
 */
public class MergeSortDemo {
    // Take an element and check until the element is greater than prev elements,
    // shift all elements to right and insert the element.
    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            mergeData(arr, start, middle, end);
        }
    }

    private static void mergeData(final int[] arr, final int start, final int mid, final int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // copy left over
        while (i < n1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[k] = right[j];
            k++;
            j++;
        }

        Utility.printArray(String.format("[start %d, middle %d, end %d] ==>", start, mid, end), arr);

    }

    public static void main(String[] args) {
        int[] arr = { 30, 12, 14, 15, 7, 9, 10, 1 };
        Utility.printArray("Before: ", arr);
        mergeSort(arr, 0, arr.length - 1);
        Utility.printArray("After:", arr);
    }
}
