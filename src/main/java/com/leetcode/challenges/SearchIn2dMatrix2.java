package com.leetcode.challenges;

/**
 * @author sanray on 12/2/2021
 */
public class SearchIn2dMatrix2 {
    public static void main(String[] args) {

        test1();

    }

    private static void test1() {
        int[][] matrix = new int[][]{{1,4},{2,5}};

        System.out.println(searchMatrix(matrix, 2));;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int colMin = 0;
        int colMax = matrix[0].length -1;

        if(rowMax == 1 && colMax == 1) {
            return matrix[0][0] == target;
        }
        int j = 0;
        for(int i = rowMax; i>=0; i--) {
            for(; j <= colMax; j++) {
                if( target == matrix[i][j]) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }

        return false;

    }
}
