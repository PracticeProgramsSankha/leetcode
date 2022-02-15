package com.leetcode.challenges;

/**
 * @author sanray on 12/2/2021
 */
public class SearchIn2dMatrix {
    public static void main(String[] args) {

        test1();

    }

    private static void test1() {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(matrix, 3));;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int index = matrix.length == 1 ? 0 : determineRow(matrix, target);
        if(index == -1) {
            return false;
        }

        // here we have found the row where possibly the target is present
        int low = 0;
        int high = matrix[0].length -1;
        while(low < high) {
            int mid = (low + high)/2;
            if(target == matrix[index][mid]) {
                return true;
            } else if (target > matrix[index][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }

    public static int determineRow(int[][] matrix, int target) {
        int maxRowIndex = matrix.length - 1;
        int maxColIndex = matrix[0].length -1;
        int low = 0;
        int high = maxRowIndex;
        while(low <= high) {
            int mid = (low + high)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][maxColIndex] ) {
                return mid;
            } else if(target < matrix[mid][0] ) {
                high = mid - 1;
            } else if(target > matrix[mid][maxColIndex] ) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
